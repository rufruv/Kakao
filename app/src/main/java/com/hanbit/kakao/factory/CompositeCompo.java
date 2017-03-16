package com.hanbit.kakao.factory;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by hb2002 on 2017-03-16.
 */

public class CompositeCompo {
    interface IComposite{public void execute();}
    final HashMap<String,Object>map = new HashMap<>();
    LinearLayout frame;
    String order;
    Context context;

    public CompositeCompo(Context context,String order) {
        this.context = context;
        this.order = order;
    }

    public LinearLayout getFrame() {
        return frame;
    }

    public HashMap<String,Object> getComponents(){
        return map;
    }

    public void execute() {
            new LinearLayoutCompo().service.execute();
            new ButtonCompo().service.execute();
            new TextViewCompo().service.execute();
            new ListViewCompo().service.execute();
            switch (order){
                case "Index":frame= (LinearLayout) map.get(order);
                    frame.addView((android.widget.TextView) map.get("HelloTextView"));
                    frame.addView((android.widget.Button) map.get("EnterButton"));
                    break;
                case "MemberList":frame= (LinearLayout) map.get(order);
                    frame.addView((android.widget.ListView) map.get("MemberListView"));
                    break;
                case "MemberDetail":frame= (LinearLayout) map.get(order);
                    frame.addView((android.widget.TextView) map.get("HelloTextView"));
                    frame.addView((android.widget.Button) map.get("EnterButton"));
                    break;
            }
        }

    class ButtonCompo{
        IComposite service = new IComposite() {
            @Override
            public void execute() {
                Button button =null;
                switch (order){
                    case "Index":
                        button =  new Button(context);
                        button.setText("ENTER");
                        button.setTextSize(17);
                        button.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        button.setBackgroundColor(Color.parseColor("#00FF00"));
                        ViewGroup.MarginLayoutParams margin =new ViewGroup.MarginLayoutParams(button.getLayoutParams());
                        margin.setMargins(0,200,0,0);
                        button.setLayoutParams(new LinearLayout.LayoutParams(margin));
                        map.put("EnterButton",button);
                        break;
                    case "MemberDetail":
                        LinearLayout.LayoutParams weight=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,1);
                        /* 구글맵%내위치보기 */
                        LinearLayout uiButton1=new LinearLayout(context);
                        uiButton1.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        Button btLocation=new Button(context);
                        btLocation.setLayoutParams(weight);
                        btLocation.setText("LOCATION");
                        btLocation.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("btLocation",btLocation);
                        Button btGoogleMap=new Button(context);
                        btGoogleMap.setLayoutParams(weight);
                        btGoogleMap.setText("GOOGLE MAP");
                        btGoogleMap.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("btGoogleMap",btGoogleMap);
                        uiButton1.addView(btLocation);
                        uiButton1.addView(btGoogleMap);
        /* 갤러리&음악*/
                        LinearLayout uiButton2=new LinearLayout(context);
                        uiButton2.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        Button btGallery=new Button(context);
                        btGallery.setLayoutParams(weight);
                        btGallery.setText("GALLERY");
                        btGallery.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("btGallery",btGallery);
                        Button btMusic=new Button(context);
                        btMusic.setLayoutParams(weight);
                        btMusic.setText("MUSIC");
                        btMusic.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("btMusic",btMusic);
                        uiButton2.addView(btGallery);
                        uiButton2.addView(btMusic);
        /* SMS&메일 */
                        LinearLayout uiButton3=new LinearLayout(context);
                        uiButton3.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        Button btSMS=new Button(context);
                        btSMS.setLayoutParams(weight);
                        btSMS.setText("SMS");
                        btSMS.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("btSMS",btSMS);
                        Button btMail=new Button(context);
                        btMail.setLayoutParams(weight);
                        btMail.setText("MAIL");
                        btMail.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("btMail",btMail);
                        uiButton3.addView(btSMS);
                        uiButton3.addView(btMail);
        /* 다이알&전화걸기 */
                        LinearLayout uiButton4=new LinearLayout(context);
                        uiButton4.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        Button btDial=new Button(context);
                        btDial.setLayoutParams(weight);
                        btDial.setText("DIAL");
                        btDial.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("btDial",btDial);
                        Button btCall=new Button(context);
                        btCall.setLayoutParams(weight);
                        btCall.setText("CALL");
                        btCall.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("btCall",btCall);
                        uiButton4.addView(btDial);
                        uiButton4.addView(btCall);
        /* 목록가기&업데이트 */
                        LinearLayout uiButton5=new LinearLayout(context);
                        uiButton5.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        Button btList=new Button(context);
                        btList.setLayoutParams(weight);
                        btList.setText("LIST");
                        btList.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("btList",btList);
                        Button btUpdate=new Button(context);
                        btUpdate.setLayoutParams(weight);
                        btUpdate.setText("UPDATE");
                        btUpdate.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("btUpdate",btUpdate);
                        uiButton5.addView(btList);
                        uiButton5.addView(btUpdate);
                        break;
                }
            }
        };
    }
    class TextViewCompo{
        IComposite service = new IComposite() {  //anonymous
            @Override
            public void execute() {
                TextView textView = null;
                switch (order){
                    case "Index":
                        textView = new TextView(context);
                        textView.setText("HELLO");
                        textView.setGravity(Gravity.CENTER);
                        textView.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        textView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        textView.setTextSize(30);
                        ViewGroup.MarginLayoutParams textViewMargin=new ViewGroup.MarginLayoutParams(textView.getLayoutParams());
                        textViewMargin.setMargins(0,200,0,0);
                        textView.setLayoutParams(new LinearLayout.LayoutParams(textViewMargin));
                        map.put("HelloTextView",textView);
                        break;
                    case "MemberDetail":
         /* ID Row */
                        LinearLayout ll1=new LinearLayout(context);
                        ll1.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        TextView tvId=new TextView(context);
                        tvId.setText("ID: ");
                        tvId.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvId.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        TextView tvIdContent=new TextView(context);
                        tvIdContent.setText("ID content");
                        tvIdContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvIdContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("tvIdContent",tvIdContent);
                        ll1.addView(tvId);
                        ll1.addView(tvIdContent);
                        map.put("ll1",ll1);
         /* Name Row */
                        LinearLayout ll2=new LinearLayout(context);
                        ll2.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        TextView tvName=new TextView(context);
                        tvName.setText("NAME: ");
                        tvName.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvName.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        TextView tvNameContent=new TextView(context);
                        tvNameContent.setText("NAME content");
                        tvNameContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvNameContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("tvNameContent",tvNameContent);
                        ll2.addView(tvName);
                        ll2.addView(tvNameContent);
                        map.put("ll2",ll2);
         /* Phone Row */
                        LinearLayout uiPhone=new LinearLayout(context);
                        uiPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        TextView tvPhone=new TextView(context);
                        tvPhone.setText("PHONE: ");
                        tvPhone.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvPhone.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        TextView tvPhoneContent=new TextView(context);
                        tvPhoneContent.setText("PHONE content");
                        tvPhoneContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvPhoneContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("tvPhoneContent",tvPhoneContent);
                        uiPhone.addView(tvPhone);
                        uiPhone.addView(tvPhoneContent);
         /* Age Row */
                        LinearLayout uiAge=new LinearLayout(context);
                        uiAge.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        TextView tvAge=new TextView(context);
                        tvAge.setText("AGE: ");
                        tvAge.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvAge.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        TextView tvAgeContent=new TextView(context);
                        tvAgeContent.setText("AGE content");
                        tvAgeContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvAgeContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("tvAgeContent",tvAgeContent);
                        uiAge.addView(tvAge);
                        uiAge.addView(tvAgeContent);
         /* Address Row */
                        LinearLayout uiAddress=new LinearLayout(context);
                        uiAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        TextView tvAddress=new TextView(context);
                        tvAddress.setText("ADDRESS: ");
                        tvAddress.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvAddress.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        TextView tvAddressContent=new TextView(context);
                        tvAddressContent.setText("ADDRESS content");
                        tvAddressContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvAddressContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("tvAddressContent",tvAddressContent);
                        uiAddress.addView(tvAddress);
                        uiAddress.addView(tvAddressContent);
         /* Salary Row */
                        LinearLayout uiSalary=new LinearLayout(context);
                        uiSalary.setLayoutParams(LayoutParamsFactory.createLayoutParams("mw"));
                        TextView tvSalary=new TextView(context);
                        tvSalary.setText("SALARY: ");
                        tvSalary.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvSalary.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        TextView tvSalaryContent=new TextView(context);
                        tvSalaryContent.setText("SALARY content");
                        tvSalaryContent.setLayoutParams(LayoutParamsFactory.createLayoutParams("ww"));
                        tvSalaryContent.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                        map.put("tvSalaryContent",tvSalaryContent);
                        uiSalary.addView(tvSalary);
                        uiSalary.addView(tvSalaryContent);
                        break;
                }
            }
        };
    }
    class EditViewCompo{
        IComposite service = new IComposite() {
            @Override
            public void execute() {

            }
        };
    }
    class ListViewCompo{
        IComposite service = new IComposite() {
            @Override
            public void execute() {
                ListView listView=null;
                switch (order){
                    case "MemberList":
                        listView=new ListView(context);
                        listView.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
                        map.put("MemberListView",listView);
                        break;
                }
            }
        };
    }
    class LinearLayoutCompo{
        IComposite service = new IComposite() {
            @Override
            public void execute() {
                LinearLayout frame=null;
                switch (order){
                    case "Index": case "MemberList": case "MemberDetail":
                        frame = new LinearLayout(context);
                        frame.setOrientation(LinearLayout.VERTICAL);
                        frame.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
                        map.put(order,frame);
                        break;
                    /*case "MemberDetail":
                        LinearLayout ui=new LinearLayout(context);
                        LinearLayout.LayoutParams weight=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,1);
                        ui.setOrientation(LinearLayout.VERTICAL);
                        ui.setLayoutParams(LayoutParamsFactory.createLayoutParams("mm"));
                        break;*/
                }
            }
        };
    }

}
