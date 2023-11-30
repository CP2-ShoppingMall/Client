package home;

import home.library.RoundJTextField;
import home.library.RoundedButton;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BodyPanel {
    /**
     * Body 부분이 바뀌는 페이지를 모아뒀습니다.
     */
}

//TODO 서버연결
//1. 상품 리스트 페이지
class ListPanel extends JPanel {
    //TODO 데이터와 연결할 때, 밑에 배열 처리한 데이터를 List<String> 이런식으로 바꾸시면 될 듯
    String[] temporary_title = {"아이폰15", "캡 모자(흰색,회색,검정색)", "갤럭시탭S9 플러스"
            , "겨울 히터기", "멀티탭", "말차 쿠키 로켓프레시"};
    String[] temporary_money = {"1,000,000", "5,000", "950,000", "80,000"
            , "12,000", "10,000"};
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
        setBackground(Color.WHITE);
        temporary_products = new JPanel[temporary_title.length];
        temporary_icons = new ImageIcon[temporary_title.length];
        temporary_imgs = new Image[temporary_title.length];
        temporary_file_labels = new JLabel[temporary_title.length];
        //각 패널에 상품 배정 (화면에 4개씩 끊어서 보여줍시다.. 스크롤 기능 노력해봤는데 실패함)
        for(int i=0; i<4; i++){
            temporary_products[i] = new JPanel();
            temporary_products[i].setSize(220,300);
            temporary_products[i].setLayout(null);
            temporary_products[i].setBackground(new Color(157,184,177));
            //상품 이미지
            temporary_icons[i] = new ImageIcon("src/home/image/product/"+(i+1)+".png");
            temporary_imgs[i] = temporary_icons[i].getImage();
            temporary_imgs[i] = temporary_imgs[i].getScaledInstance(220,230,Image.SCALE_SMOOTH);
            temporary_icons[i] = new ImageIcon(temporary_imgs[i]);
            temporary_file_labels[i] = new JLabel(temporary_icons[i]);
            temporary_file_labels[i].setBounds(0,0, 220, 230);
            //패널에 이미지 추가
            temporary_products[i].add(temporary_file_labels[i]);
            //패널에 제목 추가
            JLabel title = new JLabel(temporary_title[i]);
            title.setFont(new Font("마루 부리OTF", Font.PLAIN, 20));
            title.setBounds(10,230,220,35);
            title.setForeground(new Color(72,84,81));
            temporary_products[i].add(title);
            //패널에 가격 추가
            JLabel pay = new JLabel(temporary_money[i]);
            pay.setFont(new Font("마루 부리OTF", Font.BOLD, 20));
            pay.setBounds(10,260,220,35);
            pay.setForeground(new Color(72,84,81));
            temporary_products[i].add(pay);
            temporary_products[i].setVisible(true);
            //List패널에 상품패널추가
            row = i/2; //상품이 1행,2행,3행... 이런식으로 나열되기 위해 만든 코드
            column = i%2;
            temporary_products[i].setBounds((235*row)+12, (315*column)+15, 220,300);
            add(temporary_products[i]);
        }
        //상품 목록 다음 페이지
        pre = new JButton("◀");
        pre.setBounds(10,640,50,50);
        pre.setBackground(Color.white);
        pre.setForeground(new Color(157,184,177));
        pre.setBorder(BorderFactory.createLineBorder(new Color(157,184,177)));
        next = new JButton("▶");
        next.setBounds(420,640,50,50);
        next.setBackground(Color.white);
        next.setForeground(new Color(157,184,177));
        next.setBorder(BorderFactory.createLineBorder(new Color(157,184,177)));
        add(pre);
        add(next);setVisible(true);

    }
}

//TODO 서버연결
//2. 상품 상세 페이지
class ProductPanel extends JPanel{
    ImageIcon product_icon;
    Image product_img;
    JLabel product_img_label, product_title_label, product_price_label;
    JButton basket_btn, buy_btn;
    JPanel buy_panel;
    public ProductPanel(){
        setLayout(null);
        setSize(500,700);
        setBackground(Color.white);

        //TODO 서버 연결시 수정해야 할 부분
        //상품 사진
        product_icon = new ImageIcon("src/home/image/product/3.png");
        product_img = product_icon.getImage();
        product_img = product_img.getScaledInstance(370,370, Image.SCALE_SMOOTH);
        product_icon = new ImageIcon(product_img);
        product_img_label = new JLabel(product_icon);
        product_img_label.setBounds(40,20,370,370);
        add(product_img_label);

        //TODO 서버 연결시 수정해야 할 부분
        //구매 패널
        buy_panel = new JPanel();
        buy_panel.setLayout(null);
        buy_panel.setBackground(new Color(157,184,177));
        buy_panel.setBounds(0,430,500,255);

        product_title_label = new JLabel("갤럭시탭S9 플러스");
        product_title_label.setFont(new Font("맑은고딕", Font.BOLD, 24));
        product_title_label.setForeground(new Color(72,84,81));
        product_title_label.setBounds(20, 40, 250,30);
        buy_panel.add(product_title_label);

        product_price_label = new JLabel("950,000");
        product_price_label.setFont(new Font("맑은고딕", Font.BOLD, 34));
        product_price_label.setForeground(new Color(72,84,81));
        product_price_label.setBounds(20,65,250,60);
        buy_panel.add(product_price_label);

        basket_btn = new JButton("장바구니 담기");
        basket_btn.setBackground(new Color(72,84,81));
        basket_btn.setForeground(Color.white);
        basket_btn.setBounds(270,45,190,60);
        basket_btn.setFont(new Font("맑은 고딕",Font.BOLD,24));
        buy_panel.add(basket_btn);

        buy_btn = new JButton("구매하기");
        buy_btn.setBackground(new Color(33,39,37));
        buy_btn.setForeground(Color.white);
        buy_btn.setFont(new Font("맑은 고딕", Font.BOLD, 37));
        buy_btn.setBounds(20,135,450,90);
        buy_panel.add(buy_btn);
        add(buy_panel);
        setVisible(true);

        //TODO 장바구니, 구매하기 버튼에 addActionListener 추가하기
    }

}

//3. 판매자 글 작성 페이지
class WritePostPanel extends JPanel implements ActionListener {
    ImageIcon img_icon;
    Image img;
    JLabel img_label, title_label, price_label;
    RoundedButton complete_btn;
    JButton img_btn;
    JTextField title_txt, price_txt;

    public WritePostPanel() {
        setLayout(null);
        setBackground(Color.white);

        //TODO 서버연결
        //사진선택
        img_icon = new ImageIcon("src/home/image/icon/chooseimg.png");
        img = img_icon.getImage();
        img = img.getScaledInstance(380, 380, Image.SCALE_SMOOTH);
        img_icon = new ImageIcon(img);
        img_btn = new JButton(img_icon);
        img_btn.setBounds(50, 20, 380, 380);
        img_btn.addActionListener(this);
        img_btn.setBackground(Color.white);
        img_btn.setBorder(BorderFactory.createLineBorder(Color.white));

        add(img_btn);

        //상품명 라벨
        title_label = new JLabel("상품명");
        title_label.setBounds(40,400,120,80);
        title_label.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        title_label.setForeground(new Color(33,39,37));
        add(title_label);
        //상품명
        title_txt = new RoundJTextField(30);
        title_txt.setBackground(new Color(157,184,177));
        title_txt.setBounds(160,415,270,50);
        title_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        title_txt.setText("");
        title_txt.setBorder(new LineBorder(new Color(157,184,177)));

        add(title_txt);

        //가격 라벨
        title_label = new JLabel("가격");
        title_label.setBounds(40,470,120,80);
        title_label.setFont(new Font("마루 부리OTF",Font.BOLD,22));
        title_label.setForeground(new Color(33,39,37));
        add(title_label);
        //가격
        price_txt = new RoundJTextField(30);
        price_txt.setBackground(new Color(157,184,177));
        price_txt.setBounds(160,485,270,50);
        price_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        price_txt.setText("");
        price_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(price_txt);

        //작성 완료
        complete_btn = new RoundedButton("작성 완료");
        complete_btn.setBackground(new Color(33,39,37));
        complete_btn.setForeground(Color.white);
        complete_btn.setFont(new Font("맑은 고딕", Font.BOLD, 37));
        complete_btn.setBounds(16,580,450,90);

        add(complete_btn);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == img_btn){
            JFileChooser chooser = new JFileChooser();
            int r = chooser.showOpenDialog(this);
            if(r==JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getAbsolutePath();
                //사진 재설정
                //TODO 왜 UI에 적용 안될까요..?
                System.out.println(name);
                img_icon = new ImageIcon(name);
                img = img_icon.getImage();
                img = img.getScaledInstance(380, 380, Image.SCALE_SMOOTH);
                img_icon = new ImageIcon(img);
                img_btn = new JButton(img_icon);
                img_btn.setBounds(50, 20, 380, 380);
                repaint();
            }
        }
    }
}


class MypagePanel extends JPanel {}
//설정 화면 (회원가입 및 로그인)
class SettingPanel extends JPanel {}
//상품주문페이지 화면
class BuyPanel extends JPanel {}
//회원가입 페이지
