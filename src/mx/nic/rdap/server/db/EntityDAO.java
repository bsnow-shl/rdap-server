package mx.nic.rdap.server.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mx.nic.rdap.core.db.Entity;

/**
 * DAO for the Entity Object.This object class represents the information of
 * organizations, corporations, governments, non-profits, clubs, individual
 * persons, and informal groups of people.
 * 
 * @author dhfelix
 *
 */
public class EntityDAO extends Entity implements DatabaseObject {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * mx.nic.rdap.core.db.DatabaseObject#loadFromDatabase(java.sql.ResultSet)
	 */
	@Override
	public void loadFromDatabase(ResultSet resultSet) throws SQLException {
		setId(resultSet.getLong("ent_id"));
		setHandle(resultSet.getString("ent_handle"));
		setPort43(resultSet.getString("ent_port43"));
		setRarId(resultSet.getLong("rar_id"));
		setVCardId(resultSet.getLong("vca_id"));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.nic.rdap.core.db.DatabaseObject#storeToDatabase(java.sql.
	 * PreparedStatement)
	 */
	@Override
	public void storeToDatabase(PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, getHandle());
		preparedStatement.setString(2, getPort43());
		preparedStatement.setLong(3, getRarId());
		preparedStatement.setLong(4, getVCardId());
	}

}
