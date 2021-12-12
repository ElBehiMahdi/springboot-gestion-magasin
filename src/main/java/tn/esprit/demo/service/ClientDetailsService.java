package tn.esprit.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.repository.ClientRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClientDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientRepository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(client.getUserName(), client.getPassword(), new ArrayList<>());
    }
}
