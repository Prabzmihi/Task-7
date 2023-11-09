package CottageDBService;

import java.util.ArrayList;

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.riot.RDFDataMgr;

public class CottageDB {
	private String queryResult;
	
	public ArrayList<Cottage> searchForResult(String pathDB, String p1, String p2, String p3, String p4, String p5, String p6, String p7, String p9 ) {		

		   System.out.println("Do query...");
			
	       Model model = RDFDataMgr.loadModel(pathDB) ;
	       OntModelSpec ontModelSpec = OntModelSpec.OWL_DL_MEM;
	       OntModel ontModel = ModelFactory.createOntologyModel(ontModelSpec, model);

	       String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" + 
	       		"PREFIX e: <http://example.org/ex>\n" + 
	       		"PREFIX b: <http://example.org/ItemOntology>\n" +  
	       		"SELECT * \n" + 
	       		"WHERE {  ?item rdf:type b:Item.\n" + 
	       		"         ?item b:hasBookerName \""+p1+"\", ?booker.\n" + 
	       		"         ?item b:hasCottageName ?cottageName. \n" + 
	       		"         ?item b:hasAddress ?address. \n" + 
	       		"         ?item b:hasPlaces \""+p2+"\", ?places.\n" + 
	       		"         ?item b:hasBedrooms \""+p3+"\", ?bedRooms.\n" + 
	       		"         ?item b:hasDistanceFromLake \""+p4+"\", ?distancelake.\n" + 
	       		"         ?item b:isLocatedNearCity \""+p5+"\", ?city.\n" + 
	       		"         ?item b:hasDistanceFromCity \""+p6+"\", ?distancecity.\n" + 
	       		"         ?item b:hasNumberOfDays \""+p7+"\", ?days.\n" + 
	       		"         ?item b:hasPossibleShift \""+p9+"\", ?shift.\n" + 
	       		"         ?item b:itemID ?itemId.\n" +  
	       	    "		  BIND(\""+p2+"\" AS ?numberOfPlaces)\n" + 
	       	    "		  BIND(\""+p3+"\" AS ?numberOfBedRooms)\n" + 
	       	    "		  BIND(\""+p6+"\" AS ?cityDistance)\n" + 
	       		"		  FILTER (?places >= ?numberOfPlaces).\n" + 
	       		"		  FILTER (?bedRooms >= ?numberOfBedRooms).\n" + 
	       		"		  FILTER (?distancecity <= ?cityDistance).\n" + 
	       		"}";
	       
	       
	       Dataset dataset = DatasetFactory.create(ontModel);
	       Query q = QueryFactory.create(queryString); 

	       QueryExecution qexec = QueryExecutionFactory.create(q, dataset);
	       ResultSet resultSet = qexec.execSelect();
	       
	       ArrayList<Cottage> cot = new ArrayList<Cottage>();
	       
	       System.out.println("Results: ---");       
	       while(resultSet.hasNext()) {
	    	   QuerySolution row = (QuerySolution)resultSet.next();
	    	   Cottage cotage = new Cottage();
	    	   cotage.id = row.get("itemId").toString();
	    	   cotage.bookerName = row.get("booker").toString();
	    	   cotage.numberOfPlaces = row.get("numberOfPlaces").toString();
	    	   cotage.cottageName = row.get("cottageName").toString();
	    	   cotage.address = row.get("address").toString();
	    	   cotage.city = row.get("city").toString();
	    	   cotage.cityDistance = row.get("cityDistance").toString();
	    	   cotage.numberOfBedRooms = row.get("numberOfBedRooms").toString();
	    	   cotage.distancelake = row.get("distancelake").toString();
	    	   cotage.numberOfDays = row.get("days").toString();
	    	     	   
	    	   cot.add(cotage);
	    	   
	    	   //cotage.bedrooms = row.get("address").toString();
	    	   //RDFNode nextItemId = row.get("itemId");
	    	   //RDFNode address = row.get("address");
	    	   //System.out.print("ItemID is: "+nextItemId.toString()+".\n"); 
	    	   //System.out.print("Address is: "+address.toString()+".\n"); 
	    
	       }
	       System.out.println("------------");
	       
	       return cot;
		} 	
		
		
		public String getResult(){
			queryResult = "Done!";
			return queryResult;
		}

}
