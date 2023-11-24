package home;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

//Head
class HeadPanel extends JPanel {
    JLabel jtime, battery, wifi;
    Date time;
    SimpleDateFormat formatter;
    Timer timer;
    ImageIcon battery_icon, wifi_icon;
    Image battery_img, wifi_img;
    public HeadPanel(){
        setLayout(null);
        setSize(500,50);
        setBackground(Color.WHITE);
        //시간
        time = new Date();
        formatter = new SimpleDateFormat("HH:mm:ss");
        String formatedNow = formatter.format(time);
        jtime = new JLabel(formatedNow);
        jtime.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
        jtime.setBounds(10, 5, 100, 30);
        add(jtime);

        //배터리 이미지
        battery_icon = new ImageIcon("src/home/icon/battery.png");
        battery_img = battery_icon.getImage();
        battery_img = battery_img.getScaledInstance(50,30,Image.SCALE_SMOOTH);
        battery_icon = new ImageIcon(battery_img);
        battery = new JLabel(battery_icon);
        battery.setBounds(427,5, 50, 30);
        add(battery);

        //와이파이 이미지
        wifi_icon = new ImageIcon("src/home/icon/wifi.png");
        wifi_img = wifi_icon.getImage();
        wifi_img = wifi_img.getScaledInstance(35,30,Image.SCALE_SMOOTH);
        wifi_icon = new ImageIcon(wifi_img);
        wifi = new JLabel(wifi_icon);
        wifi.setBounds(384,5, 40, 30);
        add(wifi);

        //시간 동기화
        timer = new Timer(1000, new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 time = new Date();
                 String formatedNow = formatter.format(time);
                 jtime.setText(formatedNow);
             }
        });
        timer.start();
        setVisible(true);
    }
}


//Foot
class FootPanel extends JPanel{
    JLabel home_label, mypage_label, setting_label;
    ImageIcon home_icon, mypage_icon, setting_icon;
    Image home_img, mypage_img, setting_img;

    public FootPanel(){
        setSize(500, 120);
        setBackground(new Color(217,217,217));
        setLayout(null);
        //홈아이콘
        home_icon = new ImageIcon("src/home/icon/home.png");
        home_img = home_icon.getImage();
        home_img = home_img.getScaledInstance(60 ,60,Image.SCALE_SMOOTH);
        home_icon = new ImageIcon(home_img);
        home_label = new JLabel(home_icon);
        home_label.setBounds(20,15, 70, 70);
        add(home_label);
        //마이페이지아이콘
        mypage_icon = new ImageIcon("src/home/icon/person.png");
        mypage_img = mypage_icon.getImage();
        mypage_img = mypage_img.getScaledInstance(60,60,Image.SCALE_SMOOTH);
        mypage_icon = new ImageIcon(mypage_img);
        mypage_label = new JLabel(mypage_icon);
        mypage_label.setBounds(215,15, 70, 70);
        add(mypage_label);
        //셋팅아이콘
        setting_icon = new ImageIcon("src/home/icon/setting.png");
        setting_img = setting_icon.getImage();
        setting_img = setting_img.getScaledInstance(60,60,Image.SCALE_SMOOTH);
        setting_icon = new ImageIcon(setting_img);
        setting_label = new JLabel(setting_icon);
        setting_label.setBounds(395,15, 70, 70);
        add(setting_label);
        setVisible(true);

        //TODO 코드 구현 필요. 홈버튼, 마이페이지버튼, 환경설정 버튼 - 데이터연동
        home_label.addMouseListener(new MouseAdapter() {});
        mypage_label.addMouseListener(new MouseAdapter() {});
        setting_label.addMouseListener(new MouseAdapter() {});

    }

}


//Body
//홈 화면
class HomePanel extends JPanel {

    public HomePanel(){
        setSize(500, 900);
        setBackground(new Color(241,241,241));
        setLayout(null);
        //검색 패널
        SearchPanel search_panel = new SearchPanel();
        search_panel.setBounds(0,0,500,70);
        add(search_panel);
        //상품리스트 패널
        ListPanel list_panel = new ListPanel();
        list_panel.setBounds(0,70,500,800);
        add(list_panel);

        setVisible(true);
    }
}
class SearchPanel extends JPanel{
    JLabel search_label, basket_label;
    ImageIcon search_icon, basket_icon;
    Image search_img, basket_img;
    JTextField search_txt;
    public SearchPanel(){
        setSize(500,135);
        setLayout(null);
        //검색아이콘
        search_icon = new ImageIcon("src/home/icon/search.png");
        search_img = search_icon.getImage();
        search_img = search_img.getScaledInstance(50,55,Image.SCALE_SMOOTH);
        search_icon = new ImageIcon(search_img);
        search_label = new JLabel(search_icon);
        search_label.setBounds(350,10, 55, 55);
        add(search_label);
        //장바구니아이콘
        basket_icon = new ImageIcon("src/home/icon/basket.png");
        basket_img = basket_icon.getImage();
        basket_img = basket_img.getScaledInstance(50, 55, Image.SCALE_SMOOTH);
        basket_icon = new ImageIcon(basket_img);
        basket_label = new JLabel(basket_icon);
        basket_label.setBounds(410, 10, 55, 55);
        add(basket_label);
        //검색창
        search_txt = new JTextField(30);
        search_txt.setBackground(new Color(234,229,229));
        search_txt.setBounds(10,10,330,50);
        search_txt.setFont(new Font("맑은고딕",Font.PLAIN,24));
        search_txt.setBorder(new LineBorder(new Color(234,229,229)));
        add(search_txt);

        //TODO 코드 구현 필요. 검색/장바구니 데이터연결
        search_label.addMouseListener(new MouseAdapter() {});
        basket_label.addMouseListener(new MouseAdapter() {});

        setVisible(true);
    }
}
class ListPanel extends JPanel{
    //TODO 데이터와 연결할 때, 밑에 배열 처리한 데이터를 List<String> 이런식으로 바꾸시면 될 듯
    String[] temporary_title = {
            "아이폰15", "캡 모자(흰색,회색,검정색)", "갤럭시탭S9 플러스", "겨울 히터기", "멀티탭", "말차 쿠키 로켓프레시"
    };
    String[] temporary_money = {
            "1,000,000", "5,000", "950,000", "80,000", "12,000", "10,000"
    };
    JLabel[] temporary_title_lables;
    JLabel[] temporary_file_labels;
    ImageIcon[] temporary_icons;
    Image[] temporary_imgs;
    JPanel[] temporary_products;
    JButton pre, next;
    int row, column;
    public ListPanel(){
        setSize(500,700);
        setLayout(null);

        temporary_products = new JPanel[temporary_title.length];
        temporary_icons = new ImageIcon[temporary_title.length];
        temporary_imgs = new Image[temporary_title.length];
        temporary_file_labels = new JLabel[temporary_title.length];
        //각 패널에 상품 배정 (화면에 4개씩 끊어서 보여줍시다.. 스크롤 기능 노력해봤는데 실패함)
        for(int i=0; i<4; i++){
            temporary_products[i] = new JPanel();
            temporary_products[i].setSize(250,325);
            temporary_products[i].setLayout(null);
            //상품 이미지
            temporary_icons[i] = new ImageIcon("src/home/product/"+(i+1)+".png");
            temporary_imgs[i] = temporary_icons[i].getImage();
            temporary_imgs[i] = temporary_imgs[i].getScaledInstance(250,250,Image.SCALE_SMOOTH);
            temporary_icons[i] = new ImageIcon(temporary_imgs[i]);
            temporary_file_labels[i] = new JLabel(temporary_icons[i]);
            temporary_file_labels[i].setBounds(0,0, 250, 250);
            //패널에 이미지 추가
            temporary_products[i].add(temporary_file_labels[i]);
            //패널에 제목 추가
            JLabel title = new JLabel(temporary_title[i]);
            title.setFont(new Font("맑은 고딕", Font.PLAIN, 20));
            title.setBounds(10,250,250,35);
            temporary_products[i].add(title);
            //패널에 가격 추가
            JLabel pay = new JLabel(temporary_money[i]);
            pay.setFont(new Font("맑은 고딕", Font.BOLD, 20));
            pay.setBounds(10,280,250,35);
            temporary_products[i].add(pay);

            temporary_products[i].setVisible(true);
            //List패널에 상품패널추가
            row = i/2; //상품이 1행,2행,3행... 이런식으로 나열되기 위해 만든 코드
            column = i%2;
            temporary_products[i].setBounds((250*row), (320*column), 250,320);
            add(temporary_products[i]);
        }

        //상품 목록 다음 페이지
        pre = new JButton("◀");
        pre.setBounds(10,640,50,50);
        pre.setBackground(Color.white);
        next = new JButton("▶");
        next.setBounds(420,640,50,50);
        next.setBackground(Color.white);
        add(pre);
        add(next);

        //TODO 버튼 액션리스너 추가
        //pre.addActionListener();
        //next.addActionListener();

        setVisible(true);

    }
}


//상품페이지 화면
class ProductPanel extends JPanel {



}
//마이페이지 화면
class MypagePanel extends JPanel {}
//설정 화면 (회원가입 및 로그인)
class SettingPanel extends JPanel {}


public class ApplicationMain extends JFrame{
    public ApplicationMain(){
        setLayout(null);
        setTitle("CP2-ShoppingMall");
        setSize(500,940);
        //헤더
        HeadPanel head_panel = new HeadPanel();
        head_panel.setBounds(0,0,500,45);
        add(head_panel);
        //바디
        HomePanel home_panel = new HomePanel();
        home_panel.setBounds(0,45,500,765);
        add(home_panel);
        //푸터
        FootPanel foot_panel = new FootPanel();
        foot_panel.setBounds(0,810,500,100);
        add(foot_panel);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ApplicationMain();
        System.out.println("Hello world!");
    }
}