package base;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel player1;
	private static PersonDomainModel player2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		Date bDay = null;
		try {
			bDay = new SimpleDateFormat("yyyy-MM-dd").parse("1996-09-01");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		player1 = new PersonDomainModel();
		player1.setFirstName("Collins");
		player1.setLastName("Matthew");
		player1.setBirthday(bDay);
		player1.setCity("Norwood");
		player1.setPostalCode(02062);
		player1.setStreet("544 Neponset Street");
		
		player2 = new PersonDomainModel();
		player2.setFirstName("Brennan");
		player2.setLastName("Jacob");
		player2.setBirthday(bDay);
		player2.setCity("Poughkeepsie");
		player2.setPostalCode(12603);
		player2.setStreet("111 Main Street");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		PersonDomainModel per;	
		PersonDAL.deletePerson(player1.getPersonID());
		per = PersonDAL.getPerson(player1.getPersonID());
		assertNull("The Person shouldn't have been in the database",per);
		
		PersonDAL.deletePerson(player2.getPersonID());
		per = PersonDAL.getPerson(player2.getPersonID());
		assertNull("The Person shouldn't have been in the database",per);
	}
	
	@Test
	public void AddPersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(player1.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);		
		PersonDAL.addPerson(player1);	
		
		per = PersonDAL.getPerson(player1.getPersonID());
		System.out.println(player1.getPersonID() + " found");
		assertNotNull("The Person should have been added to the database",per);
			
		per = PersonDAL.getPerson(player2.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);		
		PersonDAL.addPerson(player2);	
		
		per = PersonDAL.getPerson(player2.getPersonID());
		System.out.println(player2.getPersonID() + " found");
		assertNotNull("The Person should have been added to the database",per);
	}
	
	@Test
	public void UpdatePersonTest()
	{		
		PersonDomainModel per;
		final String C_LASTNAME = "Smith";
		final String D_LASTNAME = "Bearnan";
		
		per = PersonDAL.getPerson(player1.getPersonID());	
		//System.out.print(per);
		assertNull("The Person shouldn't have been in the database",per);		
		PersonDAL.addPerson(player1);	
		
		player1.setLastName(C_LASTNAME);
		PersonDAL.updatePerson(player1);
		
		per = PersonDAL.getPerson(player1.getPersonID());

		assertTrue("Name Didn't Change",player1.getLastName() == C_LASTNAME);
		
		assertNull("The Person shouldn't have been in the database",per);		
		PersonDAL.addPerson(player2);	
		
		player2.setLastName(D_LASTNAME);
		PersonDAL.updatePerson(player2);
		
		per = PersonDAL.getPerson(player2.getPersonID());

		assertTrue("Name Didn't Change",player2.getLastName() == D_LASTNAME);
	}

	@Test
	public void DeletePersonTest()
	{		
		PersonDomainModel per;		
		per = PersonDAL.getPerson(player1.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);	
		
		PersonDAL.addPerson(player1);			
		per = PersonDAL.getPerson(player1.getPersonID());
		System.out.println(player1.getPersonID() + " found");
		assertNotNull("The Person should have been added to the database",per);
		
		PersonDAL.deletePerson(player1.getPersonID());
		per = PersonDAL.getPerson(player1.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);	
			
		per = PersonDAL.getPerson(player2.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);	
		
		PersonDAL.addPerson(player2);			
		per = PersonDAL.getPerson(player2.getPersonID());
		System.out.println(player2.getPersonID() + " found");
		assertNotNull("The Person should have been added to the database",per);
		
		PersonDAL.deletePerson(player2.getPersonID());
		per = PersonDAL.getPerson(player2.getPersonID());		
		assertNull("The Person shouldn't have been in the database",per);
		
	}
	
}