package app.web.calendertodo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import app.web.calendertodo.entity.FormDatas;

@Component
public class FormDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	PlatformTransactionManager transactionManager;

	private RowMapper<FormDatas> formDatasMapper = new BeanPropertyRowMapper<FormDatas>(FormDatas.class);

	public List<FormDatas> getList() {
		String sql = "SELECT * FROM formdatas";
		List<FormDatas> formdatasList = jdbcTemplate.query(sql, formDatasMapper);
		return formdatasList;
	}

	public List<FormDatas> getListByDate(Integer year, Integer month) {
		String sql = "SELECT * FROM formdatas WHERE year=? AND month=?";
		Object[] parameters = { year, month };

		List<FormDatas> formdatasList = jdbcTemplate.query(sql, parameters, formDatasMapper);
		return formdatasList;
	}

	public List<FormDatas> getListByDate(Integer year, Integer month, Integer day) {
		String sql = "SELECT * FROM formdatas WHERE year=? AND month=? AND day=?";
		Object[] parameters = { year, month, day };

		List<FormDatas> formdatasList = jdbcTemplate.query(sql, parameters, formDatasMapper);
		return formdatasList;
	}

	public int insert(FormDatas formdatas) {
		String sql = "INSERT INTO formdatas(dataid, year, month, day, time, title, content) VALUES(?,?,?,?,?,?,?)";
		Object[] parameters = { formdatas.getDataid(), formdatas.getYear(), formdatas.getMonth(), formdatas.getDay(),
				formdatas.getTime(), formdatas.getTitle(), formdatas.getContent() };
		TransactionStatus transactionStatus = null;
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		int numberOfRow = 0;
		try {
			transactionStatus = transactionManager.getTransaction(transactionDefinition);
			numberOfRow = jdbcTemplate.update(sql, parameters);
			transactionManager.commit(transactionStatus);
		} catch (DataAccessException e) {
			e.printStackTrace();
			transactionManager.rollback(transactionStatus);
		} catch (TransactionException e) {
			e.printStackTrace();
			if (transactionStatus != null) {
				transactionManager.rollback(transactionStatus);
			}
		}

		return numberOfRow;
	}

	public int delete(Integer dataid) {
		String sql = "DELETE from formdatas WHERE dataid=?";
		Object[] parameters = {dataid };

		TransactionStatus transactionStatus = null;
		DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		int numberOfRow = 0;
		try {
			transactionStatus = transactionManager.getTransaction(transactionDefinition);
			numberOfRow = jdbcTemplate.update(sql, parameters);
			transactionManager.commit(transactionStatus);
		} catch (DataAccessException e) {
			e.printStackTrace();
			transactionManager.rollback(transactionStatus);
		} catch (TransactionException e) {
			e.printStackTrace();
			if (transactionStatus != null) {
				transactionManager.rollback(transactionStatus);
			}
		}

		return numberOfRow;
	}
}
