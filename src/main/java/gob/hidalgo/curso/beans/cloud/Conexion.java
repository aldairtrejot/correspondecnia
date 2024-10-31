package gob.hidalgo.curso.beans.cloud;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import gob.hidalgo.curso.components.sysoppf.Admin.ConstantesOfiPartPf;
import lombok.Getter;
import lombok.Setter;

import org.apache.chemistry.opencmis.client.api.ItemIterable;
import org.apache.chemistry.opencmis.client.api.QueryResult;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

@Getter
@Setter
@Named
@RequestScoped
public class Conexion extends ConstantesOfiPartPf implements Serializable {
	private static final long serialVersionUID = 1L;

	// Parámetros para conexión ALFRESCO
	private Map<String, String> credentials() {
		Map<String, String> parameter = new HashMap<>();
		parameter.put(SessionParameter.USER, "admin");
		parameter.put(SessionParameter.PASSWORD, "admin");
		parameter.put(SessionParameter.ATOMPUB_URL,
				"http://127.0.0.1:8080/alfresco/api/-default-/public/cmis/versions/1.0/atom");
		parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
		return parameter;
	}
	
	private void folderDetail(Session session, String nameFile) {
		//Segmento de codigo para listar el nombre y datos de una carpeta
		String folderName = nameFile; // Nombre de la carpeta que quieres obtener
		String query = "SELECT * FROM cmis:folder WHERE cmis:name = '" + folderName + "'";
		ItemIterable<QueryResult> results = session.query(query, false);

		for (QueryResult result : results) {
			String id = (String) result.getPropertyValueById("cmis:objectId");
			String name = (String) result.getPropertyValueById("cmis:name");
			String description = (String) result.getPropertyValueById("cmis:description");

			// Imprimir los datos de la carpeta
			System.out.println("------------------");
			System.out.println("ID: " + id);
			System.out.println("Nombre: " + name);
			System.out.println("Descripción: " + description);
			
		}
		
		
		String folderId = "85143a8c-ddbb-4ba0-9191-234abe09f318"; // Reemplaza con el ID de tu carpeta

        // Consulta para obtener los documentos en la carpeta
        String query_ = "SELECT * FROM cmis:document WHERE IN_FOLDER('" + folderId + "')";
        ItemIterable<QueryResult> results_ = session.query(query_, false);

        // Procesar resultados
        for (QueryResult result : results_) {
            String id = (String) result.getPropertyValueById("cmis:objectId");
            String name = (String) result.getPropertyValueById("cmis:name");

            // Imprimir los datos de los documentos
            System.out.println("ID: " + id);
            System.out.println("Nombre: " + name);
        }
        
        
        
	}

	public String cloudInit() {
		try {
			SessionFactoryImpl factory = SessionFactoryImpl.newInstance();
			Session session = factory.getRepositories(credentials()).get(0).createSession();

			folderDetail(session, "MyFolder"); //codigo para listar los detalles de una carpeta
			folderDetail(session, "PRUEBA"); //codigo para listar los detalles de una carpeta

			return "Conexion exitosa";

		} catch (Exception e) {
			e.printStackTrace(); // Imprimir la traza del error
			return e.getMessage(); // Retornar el mensaje de error
		}
	}
}