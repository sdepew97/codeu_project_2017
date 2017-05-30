//Backend Test of ClientUser method(s)

package codeu.chat.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.InjectMocks;
import codeu.chat.util.Time;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import codeu.chat.common.BasicController;
import codeu.chat.common.Conversation;
import codeu.chat.common.Message;
import codeu.chat.common.User;
import codeu.chat.util.Logger;
import codeu.chat.util.Uuid;
import codeu.chat.util.store.Store;
import codeu.chat.util.connections.ConnectionSource;
import codeu.chat.util.connections.ClientConnectionSource;
import codeu.chat.client.Controller; 
import codeu.chat.client.ClientUser;
import codeu.chat.client.View;

@RunWith(MockitoJUnitRunner.class)
//@PrepareForTest(ClientUser.class)
public final class ClientUserTest {


	@Mock
	Controller controller;

	View view = PowerMockito.mock(View.class);

	ClientUser user;

	@Before
	public void doBefore() {
		user = Mockito.spy(new ClientUser(controller, view));
	}

	@Test
	public void testClientUserTest() {

	//	Controller controller = PowerMockito.mock(Controller.class);
	//	View view = PowerMockito.mock(View.class);
	//	user = new ClientUser(controller, view);

		//ClientUser user = Mockito.spy(new ClientUser(null, null));

		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User(new Uuid(1), "Mathangi", new Time(500)));
		userList.add(new User(new Uuid(2), "JESS", new Time(600)));
		userList.add(new User(new Uuid(3), "JesS", new Time(700)));
		userList.add(new User(new Uuid(4), "SaraH", new Time(800)));
		userList.add(new User(new Uuid(5), "SARAH", new Time(900)));

		Mockito.doReturn(userList).when(user.getUsers());

		assertEquals(true, user.isValidName("Mathangi Ganesh"));

	}


}