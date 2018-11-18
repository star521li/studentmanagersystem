
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrm implements ActionListener {	
	public  static String uid;
	public  JFrame w = new JFrame("学生成绩管理系统");
	private JMenuBar mb=new JMenuBar();
	private JMenu sysmanage = new JMenu("系统管理");
	private JMenuItem madmin=new JMenuItem("管理员信息管理");
	private JMenuItem backlogin=new JMenuItem("返回登陆");
	private JMenu jbxxgl=new JMenu("基本信息管理");	
	private JMenuItem mterm=new JMenuItem("学期信息管理");
	private JMenuItem mcourse=new JMenuItem("课程信息管理");	
	private JMenu wxgl=new JMenu("学生信息管理");
	private JMenuItem mstudent=new JMenuItem("学生信息管理");
	private JMenu tsgl=new JMenu("成绩管理");
	private JMenuItem mscore=new JMenuItem("成绩信息管理");
	private JMenuItem ckscore=new JMenuItem("成绩信息分析");
	//构成初始化界面
	MainFrm(String u){
		uid=u;
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();  
		w.setLocation((dim.width - w.getWidth()) / 2-150, (dim.height - w.getHeight()) / 2-150);  				
		w.setSize(600, 500);
		w.setResizable(false);
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
		JPanel imagePanel = (JPanel) w.getContentPane();  
		imagePanel.setOpaque(false);  
		sysmanage.add(madmin);
		sysmanage.add(backlogin);		
		jbxxgl.add(mterm);
		jbxxgl.add(mcourse);
		wxgl.add(mstudent);
		tsgl.add(mscore);
		tsgl.add(ckscore);
		mb.add(sysmanage);
		mb.add(jbxxgl);
		mb.add(wxgl);
		mb.add(tsgl);
		w.add(mb,BorderLayout.NORTH);
		//设置背景
		String path= "1.jpg";
		ImageIcon bg=new ImageIcon(path);
		JLabel bglb=new JLabel(bg);
		bglb.setBounds(0, 0, w.getWidth(), w.getHeight());
		JPanel imgpanel=(JPanel)w.getContentPane();
		imgpanel.setOpaque(false);
		w.getLayeredPane().add(bglb, new Integer(Integer.MIN_VALUE));
		//给菜单添加监听
		madmin.addActionListener(new madmin());
		backlogin.addActionListener(new backlog());		
		mcourse.addActionListener(new mcourse());
		mterm.addActionListener(new mterm());
		ckscore.addActionListener(new ckscore());
		mstudent.addActionListener(new mstudent());
		mscore.addActionListener(new mscore());
		w.setLocation(200, 200);
		w.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	//管理员信息管理
	class madmin implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new MadminFrm(w);
		}
	}
	//课程信息管理
	class mcourse implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new McourseFrm(w);
		}
	}
	//学期信息管理
	class mterm implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new MtermFrm(w);
		}
	}
	//成绩分析
	class ckscore implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new MckscoreFrm(w);
		}
	}
	//学生管理
	class mstudent implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new MstudentFrm(w);
		}
	}
	//成绩信息管理
	class mscore implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new MscoreFrm(w);
		}
	}
	//系统注销
	class backlog implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			w.dispose();
			new LoginFrm();
		}
	}
}