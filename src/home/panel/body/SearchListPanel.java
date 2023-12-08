package home.panel.body;

import home.MainFrame;
import home.panel.head.HeadPanel;

import javax.swing.*;
import java.awt.*;

//TODO 서버연결
//상품 리스트 페이지
public class SearchListPanel extends JPanel
{
    private final MainFrame Frame;
    //TODO 데이터와 연결할 때, 밑에 배열 처리한 데이터를 List<String> 이런식으로 바꾸시면 될 듯
    String[] search_title = {"말차 쿠키 로켓프레시"};
    String[] search_price = {"10,000"};
    JLabel[] search_file_labels;
    ImageIcon[] search_icons;
    Image[] search_imgs;
    JPanel[] search_result_products;
    JPanel product_list_panel;
    JButton pre, next;
    ImageIcon reload_icon;
    Image reload_img;
    JLabel reload;
    int row, column;
    public SearchListPanel(MainFrame frame)
    {
        Frame = frame;
        setSize(500,700);
        setLayout(null);
        setBackground(Color.WHITE);
        search_result_products = new JPanel[search_title.length];
        search_icons = new ImageIcon[search_title.length];
        search_imgs = new Image[search_title.length];
        search_file_labels = new JLabel[search_title.length];
        product_list_panel = new JPanel();
        product_list_panel.setLayout(null);
        product_list_panel.setBackground(Color.white);

        //헤더
        HeadPanel head_panel = new HeadPanel(Frame);
        head_panel.setBounds(0,0,500,160);
        add(head_panel);

        //각 패널에 상품 배정 (화면에 4개씩 끊어서 보여줍시다.. 스크롤 기능 노력해봤는데 실패함..ㅜㅜ)
        for(int i=0; i<1; i++){
            search_result_products[i] = new JPanel();
            search_result_products[i].setSize(220,300);
            search_result_products[i].setLayout(null);
            search_result_products[i].setBackground(new Color(157,184,177));
            //상품 이미지
            search_icons[i] = new ImageIcon("src/home/image/product/"+"6"+".png"); //TODO 숫자 6이라고 적혀있는 부분을 i로 변경하기 (서버연결시)
            search_imgs[i] = search_icons[i].getImage();
            search_imgs[i] = search_imgs[i].getScaledInstance(220,230,Image.SCALE_SMOOTH);
            search_icons[i] = new ImageIcon(search_imgs[i]);
            search_file_labels[i] = new JLabel(search_icons[i]);
            search_file_labels[i].setBounds(0,0, 220, 230);
            //패널에 이미지 추가
            search_result_products[i].add(search_file_labels[i]);
            //패널에 제목 추가
            JLabel title = new JLabel(search_title[i]);
            title.setFont(new Font("마루 부리OTF", Font.PLAIN, 20));
            title.setBounds(10,230,220,35);
            title.setForeground(new Color(72,84,81));
            search_result_products[i].add(title);
            //패널에 가격 추가
            JLabel pay = new JLabel(search_price[i]);
            pay.setFont(new Font("마루 부리OTF", Font.BOLD, 20));
            pay.setBounds(10,260,220,35);
            pay.setForeground(new Color(72,84,81));
            search_result_products[i].add(pay);
            search_result_products[i].setVisible(true);
            //List패널에 상품패널추가
            row = i/2; //상품이 1행,2행,3행... 이런식으로 나열되기 위해 만든 코드
            column = i%2;
            search_result_products[i].setBounds((235*row)+12, (315*column)+15, 220,300);
            product_list_panel.add(search_result_products[i]);
        }
        product_list_panel.setBounds(0,140,500,630);
        add(product_list_panel);

        //상품 목록 Next, Preview 버튼
        //일단은 UI상 냅두는게..
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
        add(next);
        setVisible(true);

    }

    public void search(String keyword)
    {

    }
}
