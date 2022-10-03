package com.upwork.utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.upwork.model.Freelancer;

public interface IRowMapper {
	List<Freelancer> mapRow(ResultSet resultSet) throws SQLException;
}
