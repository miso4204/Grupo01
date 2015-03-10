package processor;

import generated.Alt;
import generated.And;
import generated.Constraints;
import generated.FeatureModel;
import generated.Imp;
import generated.Not;
import generated.ObjectFactory;
import generated.Or;
import generated.Parent;
import generated.Rule;
import generated.Struct;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import annotation.ConstraintType;
import annotation.FeatureType;
/**
 * Clase principal del procesor, encargada de cargar en memoria el arbol y crear
 * los obketos necesarios para trasladarlo al modelo por medio de Jaxb
 * @author harold
 */
public class FeatureProcessor extends AbstractProcessor<CtAnnotation<?>> {
	//Feature main
	FeatureModel fm;
	//Main struc of feature model
	Struct struct;
	//Root del model
	And root;
	//Object factory constructor
	ObjectFactory factory;
	//Temporal array of feature entitys
	ArrayList<FeatureLoadEntity> tempo;
	//Temporal array of constraints entitys
	ArrayList<ConstraintLoadEntity> tempoConstraint;
	//Temporal Entitys
	FeatureLoadEntity fea;
	ConstraintLoadEntity cons;

	/**
	 * Initialize method 
	 */
	@Override
	public void init() {
		//Inicializar factory
		factory = new ObjectFactory();
		//Crear featureModel
		fm = factory.createFeatureModel();
		//Crear struct
		struct = factory.createStruct();
		//Create root
		root = factory.createAnd();
		root.setName("Biblioteca");
		root.setMandatory(true);
		struct.setAnd(root);

		tempo=new ArrayList<FeatureLoadEntity>();
		tempoConstraint=new ArrayList<ConstraintLoadEntity>();
		super.init();
	}
	/**
	 * Main method that process all annotation, loads on memory all model
	 */
	@Override
	public void process(CtAnnotation<?> annotation) {

		if((annotation.getSignature()+"").equals("@annotation.Feature"))
		{

			//Log
			//System.out.println("Constructor Found "+annotation.getElementValue("featureName"));

			//Load features in temp array
			if(!ExisteFeature(annotation.getElementValue("featureName")+""))
			{
				fea=new FeatureLoadEntity();

				//fea= factory.createAnd();
				fea.setName(annotation.getElementValue("featureName")+"");
				fea.setParentName(annotation.getElementValue("parentName")+"");
				if((annotation.getElementValue("featureType")+"").equals(FeatureType.AND.toString()))
				{
					fea.setFeatureType(FeatureType.AND);
				}else if((annotation.getElementValue("featureType")+"").equals(FeatureType.OR.toString()))
				{
					fea.setFeatureType(FeatureType.OR);
				}else if((annotation.getElementValue("featureType")+"").equals(FeatureType.ALT.toString()))
				{
					fea.setFeatureType(FeatureType.ALT);
				}else{
					fea.setFeatureType(FeatureType.NULL);
				}

				if((boolean) annotation.getElementValue("mandatory"))
				{
					//set mandatory property
					fea.setMandatory(true);
				}

				//Add to temporal array
				tempo.add(fea);
			}
		}else if((annotation.getSignature()+"").equals("@annotation.Constraint")){
			//Log
			//System.out.println("Constructor Found "+annotation.getElementValue("featureOrigin")+"---"+annotation.getElementValue("referencedFeature"));
			cons=new ConstraintLoadEntity();
			if((annotation.getElementValue("constrainType")+"").equals(ConstraintType.REQUIRES.toString()))
			{
				cons.setConstrainType(ConstraintType.REQUIRES);
			}else if((annotation.getElementValue("constrainType")+"").equals(ConstraintType.EXCLUDES.toString()))
			{
				cons.setConstrainType(ConstraintType.EXCLUDES);
			}
			cons.setFeatureOrigin(annotation.getElementValue("featureOrigin")+"");
			cons.setReferencedFeature(annotation.getElementValue("referencedFeature")+"");
			tempoConstraint.add(cons);
		}

	}	
	/**
	 * Method that pass from memory to model and writes with Jaxb
	 */
	@Override
	public void processingDone() {
		//Cargar arbol features
		crearNodos(root);

		//Cargar constraint
		crearContraints(root);


		fm.setStruct(struct);
		jaxbWriter(fm, "./resources/model.xml", "./resources/featureide.xsd");
		super.processingDone();
	}


	/**
	 * Writes the contents of a JAXB model in an xml file with identation and
	 * blank spaces
	 * 
	 * @param root
	 *            the root of the object to write
	 * @param path
	 *            destination of the file to create
	 */
	private void jaxbWriter(Object root, String path, String schema) {
		try {
			JAXBContext context = JAXBContext.newInstance(root.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, schema);
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					Boolean.TRUE);
			marshaller.marshal(root, new FileWriter(path));
		} catch (JAXBException e) {
			System.err
			.println("Error while preparing to write the JAXB model in: "
					+ path);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Error while writting the JAXB model in: "
					+ path);
			e.printStackTrace();
		}
	}

	private boolean ExisteFeature(String nodeName)
	{
		for (int i = 0; i < tempo.size(); i++) {
			if(tempo.get(i).getName().equals(nodeName))
			{
				return true;
			}
		}
		return false;
	}

	private void crearNodos(Parent nodo)
	{
		//Obtener nodos con padre = nodo
		for (int i = 0; i < tempo.size(); i++) {

			//System.out.println(tempo.get(i).getParentName());
			if(nodo.getName().equals(tempo.get(i).getParentName()))
			{
				Parent par=null;
				if(!tempo.get(i).getFeatureType().equals(FeatureType.NULL))
				{
					if(tempo.get(i).getFeatureType().equals(FeatureType.OR))
					{
						par= factory.createOr();
						((Or)par).setMandatory(tempo.get(i).isMandatory());

					}else if(tempo.get(i).getFeatureType().equals(FeatureType.ALT))
					{
						par= factory.createAlt();
						((Alt)par).setMandatory(tempo.get(i).isMandatory());
					}else{

						par= factory.createAnd();
						((And)par).setMandatory(tempo.get(i).isMandatory());
					}

					par.setName(tempo.get(i).getName());
					nodo.getAndOrAltOrOr().add(par);
					crearNodos(par);
				}else{
					generated.Feature f= factory.createFeature();
					f.setName(tempo.get(i).getName());
					f.setMandatory(tempo.get(i).isMandatory());
					nodo.getAndOrAltOrOr().add(f);
				}
			}

		}

	}

	private void crearContraints(Parent nodo)
	{
		Constraints cons= factory.createConstraints();;
		Rule rul;
		Imp imp;
		Not no;

		for (int i = 0; i < tempoConstraint.size(); i++) {
			rul=factory.createRule();
			imp=factory.createImp();
			if(tempoConstraint.get(i).getConstrainType().equals(ConstraintType.REQUIRES))
			{
				imp.getVarOrNot().add(tempoConstraint.get(i).getFeatureOrigin());
				imp.getVarOrNot().add(tempoConstraint.get(i).getReferencedFeature());
				
			}
			else if(tempoConstraint.get(i).getConstrainType().equals(ConstraintType.EXCLUDES))
			{
				imp.getVarOrNot().add(tempoConstraint.get(i).getFeatureOrigin());
				no=factory.createNot();
				no.setVar(tempoConstraint.get(i).getReferencedFeature());
				imp.getVarOrNot().add(no);
			}
			rul.getImp().add(imp);
			cons.getRule().add(rul);
		}
		
		if(!tempoConstraint.isEmpty())
		{
			fm.setConstraints(cons);
		}


	}


	private boolean tieneHijos(String featureName)
	{
		for (int i = 0; i < tempo.size(); i++) {

			System.out.println(tempo.get(i).getParentName());
			if(tempo.get(i).getParentName().equals(featureName))
			{
				return true;
			}
		}

		return false;

	}



	//	private Object ExisteFeature2(String nodeName)
	//	{
	//		if(root.getName().equals(nodeName))
	//		{
	//			return root;
	//		}else if(root.getAndOrAltOrOr().isEmpty()){
	//			return null;
	//		}else{
	//	
	//		}
	//	
	//	}
}
