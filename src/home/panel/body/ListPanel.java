package home.panel.body;

import home.panel.head.HeadPanel;

import javax.swing.*;
import java.awt.*;

//TODO 서버연결
//상품 리스트 페이지
public class ListPanel extends JPanel {
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
    JPanel product_list_panel;
    JButton pre, next;
    ImageIcon reload_icon;
    Image reload_img;
    JLabel reload;
    int row, column;
    public ListPanel(){
        setSize(500,700);
        setLayout(null);
        setBackground(Color.WHITE);
        temporary_products = new JPanel[temporary_title.length];
        temporary_icons = new ImageIcon[temporary_title.length];
        temporary_imgs = new Image[temporary_title.length];
        temporary_file_labels = new JLabel[temporary_title.length];
        product_list_panel = new JPanel();
        product_list_panel.setLayout(null);
        product_list_panel.setBackground(Color.white);

        //헤더
        HeadPanel head_panel = new HeadPanel();
        head_panel.setBounds(0,0,500,160);
        add(head_panel);
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
            product_list_panel.add(temporary_products[i]);
        }
        product_list_panel.setBounds(0,140,500,630);
        add(product_list_panel);
        //상품 목록 Next, Preview 버튼
        pre = new JButton("◀");
        pre.setBounds(10,780,50,50);
        pre.setBackground(Color.white);
        pre.setForeground(new Color(157,184,177));
        pre.setBorder(BorderFactory.createLineBorder(new Color(157,184,177)));
        next = new JButton("▶");
        next.setBounds(420,780,50,50);
        next.setBackground(Color.white);
        next.setForeground(new Color(157,184,177));
        next.setBorder(BorderFactory.createLineBorder(new Color(157,184,177)));
        //새로고침 버튼
        reload_icon = new ImageIcon("src/home/image/icon/reload.png");
        reload_img = reload_icon.getImage();
        reload_img = reload_img.getScaledInstance(45,45,Image.SCALE_SMOOTH);
        reload_icon = new ImageIcon(reload_img);
        reload = new JLabel(reload_icon);
        reload.setBounds(360,782,45,45);
        add(reload);

        add(pre);
        add(next);setVisible(true);

    }
}
