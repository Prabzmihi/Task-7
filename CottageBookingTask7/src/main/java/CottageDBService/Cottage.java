package CottageDBService;

public class Cottage {
	public String cottageName;
	public String address;
	public String city;
	public int cityDistance;
	public int numberOfPlaces;
	public int numberOfBedRooms;
	public int distancelake;
	public String imageURL;

	Cottage (String cottageName, String address, String city, int cityDistance, int numberOfPlaces, int numberOfBedRooms, int distancelake, String imageURL ){
		this.cottageName = cottageName;
		this.address = address;  
		this.city = city;
		this.cityDistance = cityDistance;
		this.numberOfPlaces = numberOfPlaces;
		this.numberOfBedRooms = numberOfBedRooms;
		this.distancelake = distancelake;
		this.imageURL = imageURL;
	}
}