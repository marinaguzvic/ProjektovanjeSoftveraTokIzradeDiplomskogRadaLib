/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.jpa.example1.domain;

import java.sql.ResultSet;

/**
 *
 * @author MARINA
 */
public interface GeneralDObject {
    String getAtrValue();
    String setAtrValue();
    String getClassName();
    String getColumnNames();
    String getWhereCondition();
    String getNameByColumn(int column);
    void checkConstraints() throws Exception;

    public void setKey(ResultSet rs) throws Exception;
    public String [] returnUniqueColumns();

    public Object getValue(String column);

    public String [] getPrimaryKeyColumns();



}
