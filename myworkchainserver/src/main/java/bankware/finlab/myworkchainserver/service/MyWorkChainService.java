package bankware.finlab.myworkchainserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bankware.finlab.myworkchainserver.entity.Billionaires;
import bankware.finlab.myworkchainserver.repository.MyWorkChainRepository;

@Service
public class MyWorkChainService {
	
	@Autowired
	private MyWorkChainRepository myWorkChainRepository;
	
	public List<Billionaires> getBillionailes() {
		return myWorkChainRepository.findAll();
	}
}
