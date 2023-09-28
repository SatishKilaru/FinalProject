package com.insurance.Hospital.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.insurance.Hospital.models.PolicyMembers;

public class PolicyMembersRowMapper implements RowMapper<PolicyMembers> {

	@Override
	public PolicyMembers mapRow(ResultSet rs, int rowNum) throws SQLException {
		PolicyMembers policyMember = new PolicyMembers();
		policyMember.setmIndex(rs.getInt(1));
		policyMember.setInsurancePolicyId(rs.getInt(2));
		policyMember.setMemberName(rs.getString(3));
		policyMember.setRelation(rs.getString(4));

		return policyMember;
	}
}
