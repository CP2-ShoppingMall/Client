package home.panel.body;

import home.library.RoundJPassWordField;
import home.library.RoundJTextField;
import home.library.RoundedButton;
import home.panel.head.TopBarPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

//임시
public class RegisterPanel extends JPanel {
    ImageIcon logo_icon;
    Image logo_img;
    JLabel logo, id, pwd, phone, address, email;
    RoundJTextField id_txt, phone_txt, address_txt, email_txt;
    RoundJPassWordField pwd_txt;
    public RoundedButton sign_btn;


    public RegisterPanel(){
        setLayout(null);
        setBackground(Color.white);

        //상단 바
        TopBarPanel topbar_panel = new TopBarPanel();
        topbar_panel.setBounds(0,0,500, 45);
        add(topbar_panel);

        //로고
        logo_icon = new ImageIcon("src/home/image/icon/mainlogo.png");
        logo_img = logo_icon.getImage();
        logo_img = logo_img.getScaledInstance(410,160,Image.SCALE_SMOOTH);
        logo_icon = new ImageIcon(logo_img);
        logo = new JLabel(logo_icon);
        logo.setBounds(40,70, 410, 160);
        add(logo);


        //아이디 라벨
        id = new JLabel("아이디");
        id.setBounds(50,250,80,80);
        id.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        id.setForeground(new Color(33,39,37));
        add(id);

        //아이디
        id_txt = new RoundJTextField(30);
        id_txt.setBackground(new Color(157,184,177));
        id_txt.setBounds(170,265,250,50);
        id_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        id_txt.setText("");
        id_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(id_txt);

        //비밀번호 라벨
        pwd = new JLabel("비밀번호");
        pwd.setBounds(50,320,120,80);
        pwd.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        pwd.setForeground(new Color(33,39,37));
        add(pwd);

        //비밀번호
        pwd_txt = new RoundJPassWordField(30);
        pwd_txt.setBackground(new Color(157,184,177));
        pwd_txt.setBounds(170,335,250,50);
        pwd_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        pwd_txt.setText("");
        pwd_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(pwd_txt);

        //이메일 라벨
        email = new JLabel("이메일");
        email.setBounds(50,390,120,80);
        email.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        email.setForeground(new Color(33,39,37));
        add(email);

        //이메일
        email_txt = new RoundJTextField(30);
        email_txt.setBackground(new Color(157,184,177));
        email_txt.setBounds(170,405,250,50);
        email_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        email_txt.setText("");
        email_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(email_txt);

        //폰번호 라벨
        phone = new JLabel("폰 번호");
        phone.setBounds(50,460,120,80);
        phone.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        phone.setForeground(new Color(33,39,37));
        add(phone);

        //폰번호
        phone_txt = new RoundJTextField(30);
        phone_txt.setBackground(new Color(157,184,177));
        phone_txt.setBounds(170,475,250,50);
        phone_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        phone_txt.setText("");
        phone_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(phone_txt);

        //주소 라벨
        address = new JLabel("집 주소");
        address.setBounds(50,535,120,80);
        address.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        address.setForeground(new Color(33,39,37));
        add(address);

        //주소
        address_txt = new RoundJTextField(30);
        address_txt.setBackground(new Color(157,184,177));
        address_txt.setBounds(170,550,250,50);
        address_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        address_txt.setText("");
        address_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(address_txt);


        //TODO 서버연결
        //회원가입
        sign_btn = new RoundedButton("회원가입");
        sign_btn.setBackground(new Color(33,39,37));
        sign_btn.setForeground(Color.white);
        sign_btn.setFont(new Font("맑은 고딕", Font.BOLD, 22));
        sign_btn.setBounds(140,650,210,55);
        add(sign_btn);


        setVisible(true);
    }
}

