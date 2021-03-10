package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Cliente;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.service.exception.ObjectNotfoundException;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repo;

	public Cliente find(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotfoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
