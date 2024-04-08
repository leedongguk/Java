import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


class start extends JFrame implements ActionListener {
	
    ImageIcon backgroundimage = new ImageIcon("./src/images/qwe.jpg"); //패널에 배경 넣기(1)
    Image back = backgroundimage.getImage(); //패널에 배경 넣기(2)
     
    JButton search; //버튼
    TextArea ta; //검색창 TextArea
    TextArea result; //결과창 TextArea
    
    start(){
        this.setTitle("DataParsing"); //타이틀 제목
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //프로세스를 닫기 위해서 필요한 코드이다.
                                                             //그냥 종료하면 화면상에서만 프로그램이 종료되고 백그라운드에서는 계속 실행되고있다.
        
        search = new JButton("검색");//검색버튼 선언
        ta = new TextArea(10,35); //검색창 선언
        result = new TextArea(10,35); //결과창 선언
         
        Panel panel = new Panel(); //화면 프레임을 JPanel로 설정하기 위해서 선언 Jpanel 장점은 다른 레이아웃 함수를 쓰는 것보다 자유로운 배치가 가능하다.
        
        panel.setLayout( null ); //패널을 절대적 위치로 설정
        panel.add(search);//패널 위에 버튼을 추가
        
        search.setBounds(400, 100, 100, 50); // 버튼 위치 및 크기 설정
        search.setContentAreaFilled(false);//버튼영역 배경표시 설정
        search.setFocusPainted(false);//버튼 포커스 표시설정
        search.addActionListener(this);//버튼에 이벤트 추가
        
        ta.setBounds(100, 100, 300, 100);//검색창 위치 및 크기 설정 (x좌표,y좌표,가로크기,세로크기)
        panel.add(ta);//패널 위에 버튼을 추가
        
        result.setBounds(100, 200, 600, 600);//결과창 위치 및 크기 설정 (x좌표,y좌표,가로크기,세로크기)
        panel.add(result);//패널 위에 버튼을 추가
        
        this.add(panel); //패널 추가
        this.setSize(900,1000);//패널 사이즈 설정
        this.setVisible(true);//기본적으로 화면에 안보이게 설정했기 때문에 반드시 setVisible(true)값으로 설정해야 화면상에 보여짐
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) { //버튼이 눌렸을때 발생하는 이벤트
    	
    	if(e.getSource() == search) {//만약 ActionEvent e값이 search 버튼 값이라면
    		
    		String get = ta.getText();//String get에 ta TextArea에 있는 텍스트를 받아온다.
    		
    		xmlsearch(get);//그리고 xmlsearch 함수에 문자열 get을 보내준다.
    		
    		
    	}
    	
    	
    }
    
    public void xmlsearch(String a) {
     	
        int page = 1;   // 페이지 초기값 
        try{
           while(true){ //break가 나올때까지 반복.
              // parsing할 url 지정(API 키 포함해서)
              String url = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey=iifF6nWLmR%2BPgzn%2BZKQfpfbSa%2FxrnJe8cRoVMGBOYvaLg0iv2dluN%2BamznkrvFKRPIQHCZkfU4shudRWucbZag%3D%3D&pageNo="+page+"&numOfRows=10&startCreateDt=20200410&endCreateDt=20200410";
              //XML에서 가져올 데이터의 url + 인증키 + 페이지 수
              
              //자신의 static 메서드를 가지고 객체를 생성 : 싱글톤 패턴
              DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
              //다른 클래스의 객체를 가지고, 객체를 생성하면 팩토리 패턴.
              DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
              Document doc = dBuilder.parse(url);
              //DOM은 XML문서로부터 인스턴스를 얻는 API를 정의한다.
              //XML을 트리 형태의 데이터로 만든 후, 해당 데이터를 가공하는 방식으로 데이터 파싱을 진행한다.
              
              // root tag 
              doc.getDocumentElement().normalize();
              System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
              
              // 파싱할 tag
              //item태그 전체를 list에 저장
              NodeList nList = doc.getElementsByTagName("item");
              //System.out.println("파싱할 리스트 수 : "+ nList.getLength());
              
              //리스트를 순회하면서 데이터를 출력
              for(int temp = 0; temp < nList.getLength(); temp++){
                 Node nNode = nList.item(temp);
                 if(nNode.getNodeType() == Node.ELEMENT_NODE){ //Node 인터페이스의 getNodeType() 메서드노드 종류를 판정할 수 있다.
                    
                    Element eElement = (Element) nNode;
                    
                    if(temp==0) {
                		result.setText("시도별 코로나 사망자 수\n");  
                		result.setText(result.getText() + "------------------------------------------\n");  
                    }
                    
                	if (getTagValue("gubun", eElement).indexOf(a) > -1) { //문자열에 문자열 a가 포함될 경우 
                		                                                   //getTagValue로 statNm의 값을 받았는데 입력된 문자열 a값이
                		                                                   //포함되면 출력하게 한다. indexOf(a) > -1는 문자열이 포함되어 있는걸 찾는다.
                	
                		//실시간으로 검색된 데이터 값을 호출하기 위해서 현재 입련된 결과창의 텍스트값을 setText로 받고 그 내용과 합쳐서 새로운 정보를 입력한다.
                		
                        
                		
                		result.setText(result.getText() + "구분: " + getTagValue("gubun", eElement)+ "\n");
                		result.setText(result.getText() + "사망자 수 합계: " + getTagValue("deathCnt", eElement)+ "\n");
                		result.setText(result.getText() + "기준일자: " + getTagValue("createDt", eElement)+ "\n");
                		result.setText(result.getText() + "----------------------------------------------------\n");
                	}             
                 }   // for end
              }   // if end
              
              page += 1;
              System.out.println("page number : "+page);
              if(page > 1){   //12페이지가 되면 break로 while문 종료.
                 break;
              }
           }   // while end
           
        } catch (Exception e){   
           e.printStackTrace();//에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력한다.
        }   // try~catch end
    	
    	
    }
    
    
    
    
    // tag값의 정보를 가져오는 메소드
   private static String getTagValue(String tag, Element eElement) {
       NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();  //getChildNodes()메소드는 자식 노드들을 NodeList타입으로 반환한다.
       Node nValue = (Node) nlList.item(0);
       if(nValue == null) 
           return null;
       return nValue.getNodeValue();
   }
    
    
    class Panel extends JPanel{ //패널에 배경 넣기(3)
            
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(back,0,0,getWidth(),getHeight(),this); //패널에 배경을 사진 크기에 맞추기 위해서 가로 값 세로 값을 받아온다.
         
        }
    }
    
    
    
}


public class search {
    public static void main(String[] args) {
        new start();
   } 

}
