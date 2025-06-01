package dao;

import java.util.List;

import model.Tipodocumento;

public interface TipoDocumentoDAO {

	public void create(Tipodocumento tipo);
	public void update(Tipodocumento tipo);
	public void delete(Integer id);
	public Tipodocumento find(Integer id);
	public List<Tipodocumento> findAll();
	
}
