package softwareevolution_gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SoftwareEvolution_GUITest {

	@Test
	void test1() {
		SoftwareEvolution_GUI obj=new SoftwareEvolution_GUI();
		ArrayList<String> selectedLangs=new ArrayList<String>();
	    ArrayList<String> tags=new ArrayList<String>();
	    if(obj.displayInfo(tags,selectedLangs)==true) {
	    	fail("");
	    }
	}
	@Test
	void test2() {
		SoftwareEvolution_GUI obj=new SoftwareEvolution_GUI();
		ArrayList<String> selectedLangs=new ArrayList<String>();
	    ArrayList<String> tags=new ArrayList<String>();
	    tags.add("Primul");
	    if(obj.displayInfo(tags,selectedLangs)==true) {
	    	fail("");
	    }
	}
	@Test
	void test3() {
		SoftwareEvolution_GUI obj=new SoftwareEvolution_GUI();
		ArrayList<String> selectedLangs=new ArrayList<String>();
	    ArrayList<String> tags=new ArrayList<String>();
	    selectedLangs.add("C++");
	    if(obj.displayInfo(tags,selectedLangs)==true) {
	    	fail("");
	    }
	}
	
	@Test
	void test4() {
		SoftwareEvolution_GUI obj=new SoftwareEvolution_GUI();
		ArrayList<String> selectedLangs=new ArrayList<String>();
	    ArrayList<String> tags=new ArrayList<String>();
	    tags.add("Primul");
	    selectedLangs.add("C++");
	    if(obj.displayInfo(tags,selectedLangs)==false) {
	    	fail("");
	    }
	}
	@Test
	void test5() {
		SoftwareEvolution_GUI obj=new SoftwareEvolution_GUI();
		ArrayList<String> selectedLangs=new ArrayList<String>();
	    ArrayList<String> tags=new ArrayList<String>();
	    tags.add("Primul");
	    for(int i=1; i<1000; i++)
	    	tags.add("Al doilea");
	    selectedLangs.add("C++");
	    if(obj.displayInfo(tags,selectedLangs)==false) {
	    	fail("");
	    }
	}
}
