package bankware.finlab.myworkchainapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankware.finlab.myworkchainapp.entity.Billionaires;
import bankware.finlab.myworkchainapp.repository.MyWorkChainRepository;

@Service
public class MyWorkChainService {
	
	@Autowired
	private MyWorkChainRepository myWorkChainRepository;
	
	public List<Billionaires> getBillionailes() {
		return myWorkChainRepository.findAll();
	}
}
