package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

@RunWith(MockitoJUnitRunner.class)
public class MockitoAppTest {

	
	@Mock
	MessageService mock;
	
	@InjectMocks
	Messenger messenger = new Messenger(mock);

	
	@Test
	public void testSendSuccess() throws MalformedRecipientException {
		Mockito.when(mock.send("http://szuflandia.pjwstk.edu.pl", "Hello!"))
		.thenReturn(SendingStatus.SENT);
		assertEquals(0, messenger.sendMessage("http://szuflandia.pjwstk.edu.pl", "Hello!"));
	}
	
	@Test
	public void testSendFailure() throws MalformedRecipientException {
		Mockito.when(mock.send("http://szuflandia.pjwstk.edu.", "Hello!"))
		.thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(1, messenger.sendMessage("http://szuflandia.pjwstk.edu.", "Hello!"));
	}
	
	
	@Test
	public void testSendException() throws MalformedRecipientException {
		Mockito.when(mock.send("", "Hello!"))
		.thenThrow(new MalformedRecipientException());
		messenger.sendMessage("", "Hello!");
	}
	
	@Test
	public void testConnectionError(){
		Mockito.when(mock.checkConnection("http://szuflandia.pjwstk.edu."))
		.thenReturn(ConnectionStatus.FAILURE);
		assertEquals(1, messenger.testConnection("http://szuflandia.pjwstk.edu."));
	}
	
	@Test
	public void testConnectionSuccess(){
		Mockito.when(mock.checkConnection("http://szuflandia.pjwstk.edu.pl"))
		.thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(0, messenger.testConnection("http://szuflandia.pjwstk.edu.pl"));
	}

}
