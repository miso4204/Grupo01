package processor;

import generated.And;
import generated.FeatureModel;
import generated.NamedElement;
import generated.ObjectFactory;
import generated.Parent;
import generated.Struct;

import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import spoon.processing.AbstractProcessor;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtMethod;
import annotation.Feature;

public class FeatureProcessor extends AbstractProcessor<CtAnnotation<Feature>> {
	FeatureModel fm;
	Struct struct;
	And root;
	ObjectFactory factory;
	@Override
	public void init() {
		//Inicializar factory
		factory = new ObjectFactory();
		//Crear featureModel
		fm = factory.createFeatureModel();
		//Crear struct
		struct = factory.createStruct();
		//Crear and root
		root = factory.createAnd();
		root.setName("Biblioteca");
		root.setMandatory(true);
		struct.setAnd(root);
		super.init();
	}

	@Override
	public void process(CtAnnotation<Feature> annotation) {
		//		if(annotation.getParent() instanceof CtClass)
		//			System.out.println("Class Found "+annotation.getParent().getSignature());
		//		else 

		if (annotation.getParent() instanceof CtMethod)
			System.out.println("Constructor Found "+annotation.getElementValue("featureName"));
		generated.Feature fea= factory.createFeature();
		fea.setName(annotation.getElementValue("featureName")+"");
		//if mandatory annotation -> set mandatory to feature fea
		if(!(boolean) annotation.getElementValue("optional"))
		{
			fea.setMandatory(true);
		}
		System.out.println("aa "+annotation.getElementValue("optional"));
		root.getAndOrAltOrOr().add(fea);

	}	

	@Override
	public void processingDone() {
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
}
