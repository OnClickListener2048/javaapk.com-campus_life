package com.yhx.app.campus_life;

import java.util.ArrayList;
import java.util.HashMap;

import com.yhx.app.service.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends BaseActivity {
	private int[] images = { R.drawable.g1, R.drawable.g2, R.drawable.g3,
			R.drawable.g4, R.drawable.g5, R.drawable.g6, R.drawable.g7,
			R.drawable.g8};//, R.drawable.gv_9 };// gridview的图片
	private String[] titles = { "行业培训类","广告类", "网络技术类", "网商类", "促销代理类",
			"酒店餐饮类","教育辅导类",  "个人中心"};//, "联系我们" };// gridview的标题
	private GridView gridView;
	private Button title_back, title_right;
	private MyApplication myApplication;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myApplication = (MyApplication) this.getApplicationContext();
		myApplication.addActivity(this);
		title_back = (Button) this.findViewById(R.id.button_back);
		title_back.setVisibility(View.GONE);
		title_right = (Button) this.findViewById(R.id.button_right);
		title_right.setVisibility(View.GONE);
		gridView = (GridView) this.findViewById(R.id.sub_gv);
		gridView.setAdapter(getMenuAdapter(titles, images));
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				switch (arg2) {
				case 0:
					intent = new Intent(MainActivity.this,
							ShopListActivity.class);
					//intent.putExtra("type", "体育用品");
					intent.putExtra("type", "行业培训类");
					MainActivity.this.startActivity(intent);
					break;
				case 1:
					intent = new Intent(MainActivity.this,
							ShopListActivity.class);
//					intent.putExtra("type", "生活用品");
					intent.putExtra("type", "广告类");
					MainActivity.this.startActivity(intent);
					break;

				case 2:
					intent = new Intent(MainActivity.this,
							ShopListActivity.class);
//					intent.putExtra("type", "自行车");
					intent.putExtra("type", "网络技术类");
					MainActivity.this.startActivity(intent);
					break;

				case 3:
					intent = new Intent(MainActivity.this,
							ShopListActivity.class);
//					intent.putExtra("type", "电子产品");
					intent.putExtra("type", "网商类");
					MainActivity.this.startActivity(intent);
					break;

				case 4:
					intent = new Intent(MainActivity.this,
							ShopListActivity.class);
//					
					intent.putExtra("type", "促销代理类");
					MainActivity.this.startActivity(intent);
					break;

				case 5:
					intent = new Intent(MainActivity.this,
							ShopListActivity.class);
//					intent.putExtra("type", "办公用品");
					intent.putExtra("type", "酒店餐饮类");
					MainActivity.this.startActivity(intent);
					break;

				case 6:
					intent = new Intent(MainActivity.this,
							ShopListActivity.class);
//					intent.putExtra("type", "电脑配件");
					intent.putExtra("type", "教育辅导类");
					MainActivity.this.startActivity(intent);
					break;

				case 7:
					intent = new Intent(MainActivity.this,
							PersonnalActivity.class);
					startActivity(intent);
					break;
				case 8:

					break;
				default:
					break;
				}
			}
		});
	}

	/**
	 * @param titles
	 *            gridview的文字数组
	 * @param imagesArray
	 *            gridview的图片数组
	 * @return
	 */
	private SimpleAdapter getMenuAdapter(String[] titles, int[] images) {
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < titles.length; i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("itemImage", images[i]);
			map.put("itemText", titles[i]);
			data.add(map);
		}
		SimpleAdapter simperAdapter = new SimpleAdapter(this, data,
				R.layout.girdview_item,
				new String[] { "itemImage", "itemText" }, new int[] {
						R.id.mygv_iv, R.id.mygv_tv });
		return simperAdapter;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
