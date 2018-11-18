
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

public class StuMainFrm implements ActionListener {	
	public  static String uid;
	public  JFrame w = new JFrame("学生成绩管理系统");
	private JMenuBar mb=new JMenuBar();
	private JMenu sysmanage = new JMenu("系统管理");
	private JMenuItem updpwd=new JMenuItem("修改密码");
	private JMenuItem backlogin=new JMenuItem("返回登陆");
	private JMenu jbxxgl=new JMenu("个人信息查看");	
	private JMenuItem stuinfo=new JMenuItem("个人信息查看");
	private JMenu wxgl=new JMenu("个人成绩查看");
	private JMenuItem stuscore=new JMenuItem("个人成绩查看");
	//构成初始化界面
	StuMainFrm(String u){
		uid=u;
		w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();  
		w.setLocation((dim.width - w.getWidth()) / 2-150, (dim.height - w.getHeight()) / 2-150);  				
		w.setSize(600, 500);
		w.setResizable(false);
		// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明  
		JPanel imagePanel = (JPanel) w.getContentPane();  
		imagePanel.setOpaque(false);  
		sysmanage.add(updpwd);
		sysmanage.add(backlogin);		
		jbxxgl.add(stuinfo);
		wxgl.add(stuscore);
		mb.add(sysmanage);
		mb.add(jbxxgl);
		mb.add(wxgl);
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
		updpwd.addActionListener(new updpwd());
		backlogin.addActionListener(new backlog());		
		stuinfo.addActionListener(new stuinfo());
		stuscore.addActionListener(new stuscore());
		w.setLocation(200, 200);
		w.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	//修改密码
	class updpwd implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new UpdpwdFrm(w);
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
	//学生信息查看
	class stuinfo implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new StuinfoFrm(w);
		}
	}
	//个人成绩查看
	class stuscore implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new StuscoreFrm(w);
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