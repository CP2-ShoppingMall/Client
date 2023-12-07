package home.panel.body;

import home.MainFrame;
import home.panel.head.HeadPanel;
import kimit.api.ClientWrapper;
import kimit.server.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

//TODO 서버연결
//상품 리스트 페이지
public class ListPanel extends JPanel
{
    private final MainFrame Frame;
    //TODO 데이터와 연결할 때, 밑에 배열 처리한 데이터를 List<String> 이런식으로 바꾸시면 될 듯
    String[] temporary_title = {"아이폰15", "캡 모자(흰색,회색,검정색)", "갤럭시탭S9 플러스"
            , "겨울 히터기", "멀티탭", "말차 쿠키 로켓프레시"};
    String[] temporary_money = {"1,000,000", "5,000", "950,000", "80,000"
            , "12,000", "10,000"};
    JLabel[] temporary_file_labels;
    ImageIcon[] temporary_icons;
    Image[] temporary_imgs;
    ListComponent[] temporary_products;
    JPanel product_list_panel;
    JButton pre, next;
    ImageIcon reload_icon;
    Image reload_img;
    JButton reload;
    int row, column;
    public HeadPanel head_panel;
    private final Font FONT = new Font("마루 부리OTF", Font.PLAIN, 20);
    private final Color COLOR = new Color(72,84,81);
    public ListPanel(MainFrame frame)
    {
        Frame = frame;
        setSize(500,700);
        setLayout(null);
        setBackground(Color.WHITE);
        temporary_products = new ListComponent[temporary_title.length];
        temporary_icons = new ImageIcon[temporary_title.length];
        temporary_imgs = new Image[temporary_title.length];
        temporary_file_labels = new JLabel[temporary_title.length];
        product_list_panel = new JPanel();
        product_list_panel.setLayout(null);
        product_list_panel.setBackground(Color.white);

        //헤더
        head_panel = new HeadPanel();
        head_panel.setBounds(0,0,500,160);
        add(head_panel);

        update(ClientWrapper.get().getClient().product());
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
        reload = new JButton(reload_icon);
        reload.setBounds(360,782,45,45);
        reload.addActionListener(e -> update(ClientWrapper.get().getClient().product()));
        add(reload);
        add(pre);
        add(next);
        setVisible(true);
    }

    public void update(ArrayList<Product> products)
    {
        for (int loop = 0; loop < 4; loop++)
        {
            if (temporary_products[loop] != null)
                temporary_products[loop].setVisible(false);
            temporary_products[loop] = new ListComponent(Frame, null);
            temporary_products[loop].setSize(220, 300);
            temporary_products[loop].setLayout(null);
            temporary_products[loop].setBackground(new Color(157,184,177));
        }

        for (int loop = 0; loop < 4 && loop < products.size(); loop++)
        {
            temporary_products[loop] = new ListComponent(Frame, products.get(loop));
            temporary_icons[loop] = new ImageIcon(products.get(loop).getImage().getScaledInstance(220, 230, Image.SCALE_SMOOTH));
            temporary_file_labels[loop] = new JLabel(temporary_icons[loop]);
            temporary_file_labels[loop].setBounds(0, 0, 220, 230);
            temporary_products[loop].add(temporary_file_labels[loop]);

            JLabel title = new JLabel(products.get(loop).getTitle());
            title.setFont(FONT);
            title.setBounds(10, 230, 220, 35);
            title.setForeground(COLOR);
            temporary_products[loop].add(title);

            JLabel price = new JLabel(products.get(loop).getPriceText());
            price.setFont(FONT);
            price.setBounds(10, 260, 220, 35);
            price.setForeground(COLOR);
            temporary_products[loop].add(price);
            temporary_products[loop].setBounds((235 * (loop % 2)) + 12, (315 * (loop / 2)) + 15, 220,300);
            temporary_products[loop].setVisible(true);
            product_list_panel.add(temporary_products[loop]);
        }
    }

    static class ListComponent extends JPanel
    {
        private final MainFrame Frame;
        private final Product Product;

        public ListComponent(MainFrame frame, Product product)
        {
            Frame = frame;
            Product = product;
            addMouseListener(new MouseAdapter()
            {
                @Override
                public void mouseClicked(MouseEvent e)
                {
                    if (Product != null)
                    {
                        ((ProductPanel) Frame.getPanel(BodyPanel.PRODUCT_DETAIL)).load(Product);
                        Frame.setPanelVisible(BodyPanel.PRODUCT_DETAIL);
                    }
                }
            });
        }

        public kimit.server.Product getProduct()
        {
            return Product;
        }
    }
}
