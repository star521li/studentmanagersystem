
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class MscoreFrm implements ActionListener {
	String cksql="select score.*,cname,sno,sname,tmname,clssname from score,course,terms,students where score.stuid=students.id and score.tmid=terms.id and score.cid=course.id ";
	JFrame w;
	JDialog jdl=new JDialog(w,"成绩信息管理",true);
	//显示信息的表
	String[] stafflistcols={"id","学号","姓名","班级","课程","分数","学期"};
	//设置表格整行显示
	DefaultTableModel model = new DefaultTableModel(null, stafflistcols);
	//数据显示表格
	JTable stafflist = new JTable(model);
	//滚动
    JScrollPane pane = new JScrollPane(stafflist);
	//查询模块
	JLabel cksnolb = new JLabel("学号：");
	JTextField cksnotxt=new JTextField();
	JLabel ckclb = new JLabel("课程：");
	@SuppressWarnings("rawtypes")
	JComboBox ckctxt=new JComboBox(); 
	JLabel cktmlb = new JLabel("学期：");
	@SuppressWarnings("rawtypes")
	JComboBox cktmtxt=new JComboBox(); 
	JButton checkbt = new JButton("查询");
	JLabel no=new JLabel("");
	//管理模块
	JLabel mgsnolb=new JLabel("学生：");
	JComboBox mgsnotxt=new JComboBox();
	JLabel mgclb=new JLabel("课程：");
	JComboBox mgctxt=new JComboBox();
	JLabel mgtmlb=new JLabel("学期：");
	@SuppressWarnings("rawtypes")
	JComboBox mgtmtxt=new JComboBox();
	JLabel mgsclb=new JLabel("分值：");
	JTextField mgsctxt=new JTextField();
	JLabel ID = new JLabel("");
	JPanel jpl=new JPanel(new BorderLayout());
	JButton addbt = new JButton("添加");
	JButton updbt = new JButton("修改");
	JButton delbt = new JButton("删除");
	JButton resbt = new JButton("重置");
	@SuppressWarnings("unchecked")
	MscoreFrm(JFrame jf){
		w=jf;
		jdl.setSize(900,400);		
		jdl.setLocation(200, 200);
		jdl.setLayout(null);
		jdl.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jdl.setResizable(false);
		//布局
		//查询部分布局
		jdl.add(cksnolb);
		jdl.add(cksnotxt);
		jdl.add(ckclb);
		jdl.add(ckctxt);
		jdl.add(cktmlb);
		jdl.add(cktmtxt);
		jdl.add(checkbt);
		jdl.add(no);
		no.setBounds(0,0,0,0);
		cksnolb.setBounds(50,10,50,20);
		cksnotxt.setBounds(110,10,100,20);
		ckclb.setBounds(230,10,50,20);
		ckctxt.setBounds(290,10,100,20);
		cktmlb.setBounds(400,10,50,20);
		cktmtxt.setBounds(450,10,100,20);
		checkbt.setBounds(600,10,60,20);
		//数据列表		
		jdl.add(pane);
		pane.setBounds(20,40,860,200);
		jpl.setBounds(20, 250, 860, 120) ;
		jdl.add(jpl);
		jpl.setBorder(BorderFactory.createTitledBorder("编辑区"));
		jpl.setOpaque(false);
		//数据管理部分布局
		jpl.add(mgsnolb);
		mgsnolb.setBounds(20, 30, 50, 20);
		jpl.add(mgsnotxt);
		mgsnotxt.setBounds(80, 30, 100, 20);
		jpl.add(mgclb);
		mgclb.setBounds(190, 30, 50, 20);
		jpl.add(mgctxt);
		mgctxt.setBounds(250, 30, 120, 20);
		jpl.add(mgtmlb);
		mgtmlb.setBounds(380, 30, 50, 20);
		jpl.add(mgtmtxt);
		mgtmtxt.setBounds(440, 30, 120, 20);
		jpl.add(mgsclb);
		mgsclb.setBounds(570, 30, 50, 20);
		jpl.add(mgsctxt);
		mgsctxt.setBounds(630, 30, 120, 20);
		jpl.add(addbt);
		addbt.setBounds(200, 60, 60, 20);
		jpl.add(updbt);
		updbt.setBounds(280, 60, 60, 20);
		jpl.add(delbt);
		delbt.setBounds(360, 60, 60, 20);
		jpl.add(resbt);
		resbt.setBounds(480, 60, 60, 20);
		jpl.add(ID);
		ID.setBounds(0,0,0,0);
		ID.setVisible(false);
		checkbt.addActionListener(new CheckAction());
		DbHelper dh=new DbHelper();
		ckctxt.addItem("选择课程");
		ResultSet rs=dh.executeQuery("select * from course");
		try {
			while(rs.next()){
				ckctxt.addItem(rs.getString("cname"));
				mgctxt.addItem(rs.getString("cname"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ckctxt.setSelectedItem("选择课程");
		cktmtxt.addItem("选择学期");
		rs=dh.executeQuery("select * from terms");
		try {
			while(rs.next()){
				cktmtxt.addItem(rs.getString("tmname"));
				mgtmtxt.addItem(rs.getString("tmname"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cktmtxt.setSelectedItem("选择学期");		
		rs=dh.executeQuery("select * from students");
		try {
			while(rs.next()){
				mgsnotxt.addItem(rs.getString("sno")+"_"+rs.getString("sname"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		stafflist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//数据列表添加鼠标监听
		stafflist.addMouseListener(new java.awt.event.MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
            	//获取鼠标选中那一行的数据
              int r= stafflist.getSelectedRow();
              //获取每一列的值，赋值给右侧编辑区
              Object value= stafflist.getValueAt(r, 0);
              ID.setText(value.toString());
              mgsnotxt.setSelectedItem(stafflist.getValueAt(r, 1).toString()+"_"+stafflist.getValueAt(r, 2));
              mgctxt.setSelectedItem(stafflist.getValueAt(r, 4).toString());
              mgsctxt.setText(stafflist.getValueAt(r, 5).toString());
              mgtmtxt.setSelectedItem(stafflist.getValueAt(r, 6).toString());
            }
        });
		//为增删改重置功能添加监听事件
		addbt.addActionListener(new AddAction());
		updbt.addActionListener(new UpdAction());
		delbt.addActionListener(new DelAction());
		resbt.addActionListener(new ResAction());
		getData(cksql);
		
		jdl.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}
	//查询功能实现
	class CheckAction implements ActionListener{		
		ResultSet rs=null;		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method coub			
			//获取数据，绑定到数据表
			getData(cksql);
		}
	}
	//添加功能实现
	class AddAction implements ActionListener{
		String sql="";
		ResultSet rs=null;
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method coub
			String sno=mgsnotxt.getSelectedItem().toString().trim();
			String cname=mgctxt.getSelectedItem().toString().trim();
			String tmname=mgtmtxt.getSelectedItem().toString().trim();
			String sc=mgsctxt.getText().trim();
			String [] str=sno.split("_");
			
			if("".equals(sno)||"".equals(cname)||"".equals(tmname)||"".equals(sc)){
				JOptionPane.showMessageDialog(null,"成绩信息不完整!", "系统信息", JOptionPane.WARNING_MESSAGE);	
				return;
			}
			DbHelper db=new DbHelper();			
			Object stuid=db.getOnlyOne("select id from students where sno='"+str[0]+"'");
			Object cid=db.getOnlyOne("select id from course where cname='"+cname+"'");
			Object tmid=db.getOnlyOne("select id from terms where tmname='"+tmname+"'");			
			int x=db.executeUpdate("insert into score(stuid,cid,tmid,val) values("+stuid+","+cid+","+tmid+","+sc+")");
			if(x>0){
				JOptionPane.showMessageDialog(null,"添加成功.", "系统信息", JOptionPane.INFORMATION_MESSAGE);	
			}else{
				JOptionPane.showMessageDialog(null,"系统错误01", "系统信息", JOptionPane.ERROR_MESSAGE);	
			}
			//获取数据，绑定到数据表
			getData(cksql);
			//重置
			rst();
		}
	}
	//重置功能实现
	class ResAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method coub
			rst();
		}
	}
	//删除功能实现
	class DelAction implements ActionListener{
		ResultSet rs=null;	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method coub
			String id=ID.getText();
			DbHelper db=new DbHelper();
			if("".equals(id)||!db.checkTrue("select id from score where id="+id)){
				JOptionPane.showMessageDialog(null,"请选择所要删除的信息!", "系统信息", JOptionPane.WARNING_MESSAGE);	
				return;
			}			
			int x=db.executeUpdate("delete from score where id="+id);
			if(x>0){
				JOptionPane.showMessageDialog(null,"删除成功.", "系统信息", JOptionPane.INFORMATION_MESSAGE);	
				//获取数据，绑定到数据表
				getData(cksql);
				//重置
				rst();
			}else{
				JOptionPane.showMessageDialog(null,"系统错误01", "系统信息", JOptionPane.ERROR_MESSAGE);	
			}			
		}
	}
	//修改功能实现
	class UpdAction implements ActionListener{
		ResultSet rs=null;	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method coub
			String id=ID.getText();
			if("".equals(id)){
				JOptionPane.showMessageDialog(null,"请选择所要修改的信息!", "系统信息", JOptionPane.WARNING_MESSAGE);	
				return;
			}
			String sno=mgsnotxt.getSelectedItem().toString().trim();
			String cname=mgctxt.getSelectedItem().toString().trim();
			String tmname=mgtmtxt.getSelectedItem().toString().trim();
			String sc=mgsctxt.getText().trim();
			String [] str=sno.split("_");
			
			if("".equals(sno)||"".equals(cname)||"".equals(tmname)||"".equals(sc)){
				JOptionPane.showMessageDialog(null,"成绩信息不完整!", "系统信息", JOptionPane.WARNING_MESSAGE);	
				return;
			}
			DbHelper db=new DbHelper();			
			Object stuid=db.getOnlyOne("select id from students where sno='"+str[0]+"'");
			Object cid=db.getOnlyOne("select id from course where cname='"+cname+"'");
			Object tmid=db.getOnlyOne("select id from terms where tmname='"+tmname+"'");			
			int x=db.executeUpdate("update score set stuid="+stuid+",cid="+cid+",tmid="+tmid+",val="+sc+" where id="+id);
			if(x>0){
				JOptionPane.showMessageDialog(null,"修改成功.", "系统信息", JOptionPane.INFORMATION_MESSAGE);	
				//获取数据，绑定到数据表
				getData(cksql);
				//重置
				rst();
			}else{
				JOptionPane.showMessageDialog(null,"系统错误01", "系统信息", JOptionPane.ERROR_MESSAGE);	
			}
		}
	}
	//获取查询结果，绑定到数据表
	public void getData(String sql){
		//如果查询有结果，则清空以往数据
		if(model.getRowCount()>0){
			for(int i=model.getRowCount()-1;i>=0;i--){
				model.removeRow(i);
			}
		}
		DbHelper db=new DbHelper();
		if(!"选择课程".equals(ckctxt.getSelectedItem().toString())){
			sql+=" and cname='"+ckctxt.getSelectedItem()+"'";
		}
		if(!"选择学期".equals(cktmtxt.getSelectedItem().toString())){
			sql+=" and tmname='"+cktmtxt.getSelectedItem()+"'";
		}
		if(!"".equals(cksnotxt.getText().toString())){
			sql+=" and sno='"+cksnotxt.getText()+"'";
		}
		ResultSet rs=db.executeQuery(sql);
		if(rs!=null){
			try {
				while(rs.next()){
					model.addRow(new String[]{String.valueOf(rs.getInt("ID")),rs.getString("sno"),rs.getString("sname"),rs.getString("clssname"),rs.getString("cname"),rs.getString("val"),rs.getString("tmname")});
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void rst(){
		ID.setText("");
		mgsctxt.setText("0");
	}
}
