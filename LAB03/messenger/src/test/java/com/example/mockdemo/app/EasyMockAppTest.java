package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
//import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;


@RunWith(EasyMockRunner.class)
public class EasyMockAppTest {

	/*
	private Messenger myMess;
	private MessageService myMessService;
	
	@Before
	public void setUp() {
		myMessService = createMock(MessageService.class);
		myMess = new Messenger(myMessService);
	}*/
	
	@Mock
	private MessageService myMessService;
	
	@TestSubject
	private Messenger myMess = new Messenger(myMessService);
	
	@Test
	public void testConnectionSuccess() {
		expect(myMessService.checkConnection("http://szuflandia.pjwstk.edu.pl"))
		.andReturn(ConnectionStatus.SUCCESS)
		.anyTimes();
		replay(myMessService);
		assertEquals(0, myMess.testConnection("http://szuflandia.pjwstk.edu.pl"));
		verify(myMessService);
	}

	@Test
	public void testConnectionFailure() {
		expect(myMessService.checkConnection("http://szuflandia.pjwstk.edu."))
		.andReturn(ConnectionStatus.FAILURE)
		.anyTimes();
		replay(myMessService);
		assertEquals(1, myMess.testConnection("http://szuflandia.pjwstk.edu."));	
		verify(myMessService);
	}
	
	@Test
	public void testSendMessageSuccess() {
		try {
			expect(myMessService.send("http://szuflandia.pjwstk.edu.pl", "Hello!"))
			.andReturn(SendingStatus.SENT)
			.times(1);
		} catch (MalformedRecipientException e) {
			e.printStackTrace();
		}
		replay(myMessService);
		assertEquals(0, myMess.sendMessage("http://szuflandia.pjwstk.edu.pl", "Hello!"));	
		verify(myMessService);
	}
	
	@Test
	public void testSendMessageFailure() throws MalformedRecipientException {
			expect(myMessService.send("http://szuflandia.pjwstk.edu.pl", ""))
			.andReturn(SendingStatus.SENDING_ERROR)
			.anyTimes();
		replay(myMessService);
		assertEquals(1, myMess.sendMessage("http://szuflandia.pjwstk.edu.pl", ""));	
		verify(myMessService);
	}
	
	@Test
	public void testSendMessageException() throws MalformedRecipientException {
			expect(myMessService.send("", "Hello!"))
			.andThrow(new MalformedRecipientException())
			.times(1);
		
		replay(myMessService);
		myMess.sendMessage("", "Hello!");	
		verify(myMessService);
	}

}
