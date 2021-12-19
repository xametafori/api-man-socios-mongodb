package com.ms.practica2.service;


import com.ms.practica2.models.Socio;
import com.ms.practica2.repository.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service("serviceRestTemplate")
public class SocioServiceImpl implements SocioService {

	@Autowired
	private SocioRepository socioRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Socio> findAll() {
		return (List<Socio>)socioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Socio> findById(String dni) {
		return socioRepository.findById(dni);
	}

	@Override
	@Transactional(readOnly = true)
	public Socio save(Socio item) {
		return socioRepository.save(item);
	}


	@Override
	@Transactional(readOnly = true)
	public void delete(String dni) {
		socioRepository.deleteById(dni);
	}

	@Override
	public boolean existsById(String dni) {
		return socioRepository.existsById(dni);
	}
}
