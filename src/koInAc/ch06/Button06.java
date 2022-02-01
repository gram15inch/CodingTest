package koInAc.ch06;

public class Button06 {
    public void setOnclickListener(OnclickListener l){}
    public void run(){
        setOnclickListener(new OnclickListener() {
            @Override
            public void onClick(String v) {
                System.out.println(v);
            }
        });
    }
}
