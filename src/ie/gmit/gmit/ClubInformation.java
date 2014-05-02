package ie.gmit.gmit;

import android.webkit.WebView.FindListener;

/* 
 * This class holds the data for all the clubs, eventually I would like this read in by a fileReader
 */

public class ClubInformation {
	private String[] names = new String[] {
			"ACE Society", 
			"Anime & Manga", 
			"Archery Club", 
			"Athletics", 
			"Badminton", 
			"Basketball", 
			"Best Buddies GMIT", 
			"Boxing", 
			"Camogie", 
			"Computer Society", 
			"Cricket", 
			"Cumann Gaelach", 
			"Darts Club", 
			"DJ Society", 
			"Engineering Society",  
			"Equestrian Society", 
			"Fianna Fail Society", 
			"Film Making Society", 
			"Foir Oige", 
			"Futsal", 
			"Gaelic Football - Mens", 
			"Gaelic Football - Womens", 
			"Gaming Society", 
			"GMIT Wishmakers On Campus", 
			"Handball", 
			"Hurling", 
			"Heritage Society", 
			"International Society", 
			"Indoor Soccer", 
			"Karate", 
			"Karting Society", 
			"Kayak", 
			"Kickboxing", 
			"Letterfrack", 
			"LGBT Society", 
			"Living History Society", 
			"Mature Students Society", 
			"Photography Society - Flash Mob", 
			"Robotics Society", "Rugby Club", 
			" Science Society", 
			"Sinn Fein", 
			"Soccer", 
			"Sub-Aqua", 
			"Surfing", 
			"Swing Dance", 
			"Table Tennis", 
			"Air Soft", 
			"Tag Rugby", 
			"Trampolining/Gymnastics", 
			"Volleyball", 
			"Womens Rugby"};

	private String[] bodys = new String[] {
			"Activities, Challenges and Events to promote Fitness, Wellness and Happiness in GMIT",
			"GMIT Anime and Manga Society was established in 2010 and is dedecated to bringing you the finest Japanese animated shows twice a week. This page is generally only used for announcements and the like, to talk to fellow members and ask questions you are recommended to use the group or forums.", 
			"Archery Club", 
			"Athletics", 
			"Badminton", 
			"Basketball", 
			"Mission:\nTo change lives one friendship at a time :)\n\nDescription:\nWe are student volunteers who are paired up with people with intellectual disabilities, we give them opportunities that they would not usually have in everyday life. Us and our buddies take part in activities like disco's, the end of year best buddies ball, art nights, sports and more!\n\nPresident - Katherine Long\nVice - John Murphy\nSecretary - Jason Burke\nTreasurer - John McNamara", 
			"Boxing", 
			"Camogie", 
			"GMIT Computer Society - bringing people together who have a shared interest in computing & would like to explore new areas/aspects.\n\nDescription:\nStudying Software or Digital Media?\n\nWant to make Mobile, Tablet & Desktop Apps?\n\nInterested in making Games ?\n\nCan you count in binary?\n\nInto sci-fi movies/tv?\n\nLike playing video-games?\n\nInterested in programming/electronics?\n\nWant to meet like-minded people?\n\nDon't be shy, come along!", 
			"Cricket", 
			"Cumann Gaelach", 
			"Darts Club", 
			"DJ Society", 
			"Engineering Society",  
			"Equestrian Society", 
			"Fianna Fail Society", 
			"Film Making Society", 
			"Foir Oige", 
			"Futsal", 
			"Gaelic Football - Mens", 
			"Gaelic Football - Womens", 
			"Gaming Society", 
			"GMIT Wishmakers On Campus", 
			"Handball", 
			"Hurling", 
			"Heritage Society", 
			"International Society", 
			"Indoor Soccer", 
			"Karate", 
			"Karting Society", 
			"Kayak", 
			"Kickboxing", 
			"Letterfrack", 
			"LGBT Society", 
			"Living History Society", 
			"Mature Students Society", 
			"Photography Society - Flash Mob", 
			"Robotics Society", "Rugby Club", 
			" Science Society", 
			"Sinn Fein", 
			"Soccer", 
			"Sub-Aqua", 
			"Surfing", 
			"Swing Dance", 
			"Table Tennis", 
			"Air Soft", 
			"Tag Rugby", 
			"Trampolining/Gymnastics", 
			"Volleyball", 
			"Womens Rugby"};
	
	private String[] links = new String[] {
			"https://www.facebook.com/aceofclubsgmit", 
			"https://www.facebook.com/gmitanimemangasoc", 
			"http://gmitsu.ie/clubssocs/directory.html", 
			"http://gmitsu.ie/clubssocs/directory.html", 
			"http://gmitsu.ie/clubssocs/directory.html", 
			"http://gmitsu.ie/clubssocs/directory.html", 
			"https://www.facebook.com/pages/Best-Buddies-GMIT/305305566158422", 
			"Boxing", 
			"Camogie", 
			"https://www.facebook.com/GMITComputerSociety", 
			"Cricket", 
			"Cumann Gaelach", 
			"Darts Club", 
			"DJ Society", 
			"Engineering Society",  
			"Equestrian Society", 
			"Fianna Fail Society", 
			"Film Making Society", 
			"Foir Oige", 
			"Futsal", 
			"Gaelic Football - Mens", 
			"Gaelic Football - Womens", 
			"Gaming Society", 
			"GMIT Wishmakers On Campus", 
			"Handball", 
			"Hurling", 
			"Heritage Society", 
			"International Society", 
			"Indoor Soccer", 
			"Karate", 
			"Karting Society", 
			"Kayak", 
			"Kickboxing", 
			"Letterfrack", 
			"LGBT Society", 
			"Living History Society", 
			"Mature Students Society", 
			"Photography Society - Flash Mob", 
			"Robotics Society", "Rugby Club", 
			" Science Society", 
			"Sinn Fein", 
			"Soccer", 
			"Sub-Aqua", 
			"Surfing", 
			"Swing Dance", 
			"Table Tennis", 
			"Air Soft", 
			"Tag Rugby", 
			"Trampolining/Gymnastics", 
			"Volleyball", 
			"Womens Rugby"};
	
	private String[] images = new String[] {
			"R.drawable.clubAce", 
			"Anime & Manga", 
			"Archery Club", 
			"Athletics", 
			"Badminton", 
			"Basketball", 
			"Best Buddies GMIT", 
			"Boxing", 
			"Camogie", 
			"Computer Society", 
			"Cricket", 
			"Cumann Gaelach", 
			"Darts Club", 
			"DJ Society", 
			"Engineering Society",  
			"Equestrian Society", 
			"Fianna Fail Society", 
			"Film Making Society", 
			"Foir Oige", 
			"Futsal", 
			"Gaelic Football - Mens", 
			"Gaelic Football - Womens", 
			"Gaming Society", 
			"GMIT Wishmakers On Campus", 
			"Handball", 
			"Hurling", 
			"Heritage Society", 
			"International Society", 
			"Indoor Soccer", 
			"Karate", 
			"Karting Society", 
			"Kayak", 
			"Kickboxing", 
			"Letterfrack", 
			"LGBT Society", 
			"Living History Society", 
			"Mature Students Society", 
			"Photography Society - Flash Mob", 
			"Robotics Society", "Rugby Club", 
			" Science Society", 
			"Sinn Fein", 
			"Soccer", 
			"Sub-Aqua", 
			"Surfing", 
			"Swing Dance", 
			"Table Tennis", 
			"Air Soft", 
			"Tag Rugby", 
			"Trampolining/Gymnastics", 
			"Volleyball", 
			"Womens Rugby"};
	
	public ClubInformation(){
		init();
	}
	
	public void init(){
		//ClubInformation initilize = new ClubInformation();
	}
	
	public String getName(int position) {
		return names[position];
	}

	public String getLink(int position) {
		return links[position];
	}

	public String getImage(int position) {
		return images[position];
	}	

	public String getBody(int position) {
		return bodys[position];
	}	
	
	public int getLen(){
		return names.length;
	}
}
