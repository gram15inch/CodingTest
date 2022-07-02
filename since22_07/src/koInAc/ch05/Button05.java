package koInAc.ch05;

public class Button05 {
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
