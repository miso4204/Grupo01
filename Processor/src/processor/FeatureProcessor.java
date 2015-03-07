package processor;

import generated.Alt;
import generated.And;
import generated.FeatureModel;
import generated.ObjectFactory;
import generated.Or;
import generated.Parent;
import generated.Struct;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import annotation.Feature;
import annotation.FeatureType;
/**
 * 
 * @author harold
 *
 */
public class FeatureProcessor extends AbstractProcessor<CtAnnotation<Feature>> {
	FeatureModel fm;
	Struct struct;
	And root;
	ObjectFactory factory;
	ArrayList<FeatureLoadEntity> tempo;
	FeatureLoadEntity fea;


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
		super.init();
	}

	@Override
	public void process(CtAnnotation<Feature> annotation) {

		//Log
		System.out.println("Constructor Found "+annotation.getElementValue("featureName"));

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
	}	

	@Override
	public void processingDone() {
		//root.getAndOrAltOrOr().add(fea);

		//Cargar arbol
		//Para cada nodo crearlo, buscar al papa y agregarselo, si no existe el
		//papa crearlo
		crearNodos(root);


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

			System.out.println(tempo.get(i).getParentName());
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
