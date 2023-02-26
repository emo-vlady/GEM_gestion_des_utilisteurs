package cm.cti.utilisateur.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cm.cti.utilisateur.Repositories.EmployeRepository;
import cm.cti.utilisateur.exceptions.DAOException;
import cm.cti.utilisateur.exceptions.FormValidationException;
import cm.cti.utilisateur.models.Employe;
import cm.cti.utilisateur.service.EmployeIService;
import jakarta.persistence.NoResultException;
@Service
public class EmployeService implements EmployeIService {

	@Autowired
	private EmployeRepository repository;
	
	@Override
	public List<Employe> getAll() throws DAOException {
		try {
			return repository.findAll();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoResultException e) {
			return new ArrayList<>();
		}
	}

	@Override
	public void add(Employe entity) throws DAOException {
		try {
			entity.setId(null);
			repository.save(entity);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void update(Employe entity) throws DAOException {
		try {
			repository.save(entity);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public void delete(Long id) throws DAOException {
		try {
			repository.delete(find(id));
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Employe find(Long id) throws DAOException {
	  try {
		return repository.findById(id).get();
	} catch (DAOException e) {
		throw new DAOException(e.getMessage());
	} catch (NoSuchElementException e) {
		return null;
	}
	}

	@Override
	public void saveAll(Iterable<Employe> iterable) throws DAOException {
		try {
			repository.saveAll(iterable);
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		}
	}

	@Override
	public Employe findId(Long id) throws FormValidationException {
		try {
			return repository.findById(id).get();
		} catch (DAOException e) {
			throw new DAOException(e.getMessage());
		} catch (NoSuchElementException e) {
			throw new FormValidationException(e.getMessage());
		}
	}
}
