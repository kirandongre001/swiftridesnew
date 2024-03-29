package com.swiftrides.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swiftrides.models.State;
import com.swiftrides.repositories.StateRepository;

@Service
public class StateService 
{
	@Autowired
	StateRepository srepo;
	
	public List<State> getStates()
	{
		return srepo.findAll();
	}
	
	public State getState(int stateid)
	{
		Optional<State> ostate=srepo.findById(stateid);
		State s=null;
		try
		{
			s=ostate.get();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}
}

