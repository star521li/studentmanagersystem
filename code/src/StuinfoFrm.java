
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StuinfoFrm implements ActionListener {	
	JFrame w;
	JDialog jdl=new JDialog(w,"学生信息查看",true);
	String sid="";
	JLabel snolb=new JLabel("学号：");
	JTextField snotxt=new JTextField("");
	JLabel snamelb=new JLabel("姓名：");
	JTextField snametxt=new JTextField("");
	JLabel genderlb=new JLabel("性别：");
	JTextField gendertxt=new JTextField("");
	JLabel clssnamelb=new JLabel("班级：");
	JTextField clssnametxt=new JTextField("");
	StuinfoFrm(JFrame jf){
		w=jf;
		jdl.setSize(269,260);		
		jdl.setLocation(200, 260);
		jdl.setLayout(null);
		jdl.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		jdl.setResizable(false);
		jdl.add(snolb);
		jdl.add(snotxt);
		jdl.add(snamelb);
		jdl.add(snametxt);
		jdl.add(genderlb);
		jdl.add(gendertxt);
		jdl.add(clssnamelb);
		jdl.add(clssnametxt);
		snolb.setBounds(30, 40, 80, 20);
		snotxt.setBounds(115, 40, 120, 20);
		snamelb.setBounds(30, 65, 80, 20);
		snametxt.setBounds(115, 65, 120, 20);
		genderlb.setBounds(30, 90, 80, 20);
		gendertxt.setBounds(115, 90, 120, 20);
		clssnamelb.setBounds(30, 115, 80, 20);
		clssnametxt.setBounds(115, 115, 120, 20);	
		//布局
		snotxt.setEnabled(false);
		snametxt.setEnabled(false);
		gendertxt.setEnabled(false);
		clssnametxt.setEnabled(false);
		DbHelper dh=new DbHelper();
		ResultSet rs=dh.executeQuery("select * from students where id="+StuMainFrm.uid);
		try {
			while(rs.next()){
				snotxt.setText(rs.getString("sno"));
				snametxt.setText(rs.getString("sname"));
				gendertxt.setText(rs.getString("gender"));
				clssnametxt.setText(rs.getString("clssname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdl.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method coub
	}
}
