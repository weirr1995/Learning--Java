package graduation;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class StudentTableModelStart extends AbstractTableModel{
	String[] columnNames = new String[] { "������", "��������", "��������", "������ʦ","ָ����ʦ","��ѡ����" };
	List<CT> listCT;
	DAO<CT> CT;
	List<Teacher> listT;
	DAO<Teacher> T;
	public StudentTableModelStart(DAO<CT> CT,DAO<Teacher> T) {
		this.CT=CT;
		listCT=CT.list();
		this.T=T;
		listT=T.list();
	}
	@Override
	
	public int getRowCount() {
        // TODO Auto-generated method stub
        return listCT.size();
    }
 
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }
 
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }
 
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    // ��ͨ��heros.get(rowIndex)��ȡ�ж�Ӧ��Hero����
    // Ȼ�����columnIndex���ض�Ӧ������
    public Object getValueAt(int rowIndex, int columnIndex) {
        CT ct = listCT.get(rowIndex);
        if (0 == columnIndex)
            return ct.id;
        if (1 == columnIndex)
            return ct.cname;
        if (2 == columnIndex)
            return ct.ctype;
        if (3 == columnIndex)
        	for(Teacher t:listT)if(t.tno.equals(ct.tno))
        		return t.tn;  
        if (4 == columnIndex)
        	for(Teacher t:listT)if(t.tno.equals(ct.ctno))
        		return t.tn;
        if (5 == columnIndex)
            return ct.climit;
        return null;
    }

}