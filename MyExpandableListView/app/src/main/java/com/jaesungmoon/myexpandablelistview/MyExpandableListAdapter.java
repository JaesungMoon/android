package com.jaesungmoon.myexpandablelistview;


import android.app.ExpandableListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyExpandableListAdapter extends ExpandableListActivity {

    ExpandableListAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // インナークラスでアダプターの内容をセット
        mAdapter = new MyExpandableListAdapterInner();
        // アダプターをExpandableListViewにセット
        setListAdapter(mAdapter);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition,
                                int childPosition, long id) {

        // 子要素がクリックされたら内容をToastで表示する
        Object o = mAdapter.getChild(groupPosition, childPosition);
        Toast.makeText(getApplicationContext(), o.toString(), Toast.LENGTH_SHORT).show();

        return super.onChildClick(parent, v, groupPosition, childPosition, id);
    }

    /***
     * アダプタークラス
     */
    public class MyExpandableListAdapterInner extends BaseExpandableListAdapter {

        // @formatter:off
        private final String[] groups = {"Group1", "Group2", "Group3"};
        private final String[][][] children = {
                {{"Group1 Child1", "Child text1"},
                        {"Group1 Child2", "Child text2"},
                        {"Group1 Child3", "Child text3"}},
                {{"Group2 Child1", "Child text1"}},
                {{"Group3 Child1", "Child text1"},
                        {"Group3 Child2", "Child text2"},
                        {"Group3 Child3", "Child text3"},
                        {"Group3 Child4", "Child text4"},
                        {"Group3 Child5", "Child text5"}}
        };
        // @formatter:on

        /** レイアウトをインフレートするための変数 */
        private LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);;

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return children[groupPosition][childPosition][0];
        }

        /***
         * 子要素を返す（オーバーロード）
         *
         * @param groupPosition
         * @param childPosition
         * @param textPosition
         * @return
         */
        public String getChild(int groupPosition, int childPosition, int textPosition) {
            return children[groupPosition][childPosition][textPosition];
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return children[groupPosition].length;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {

            // 子要素のViewを作る
            // convertViewがnullの時だけインフレートする（１行ごとに呼ばれるので使いまわす）
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.expandablechildview,
                        null);
            }

            // 子要素の現在位置が奇数の場合はグレー、偶数の場合は黒を背景にセットする
            LinearLayout linearLayout = convertView.findViewById(R.id.ChildLinearLayout);
            if ((childPosition % 2) != 0) {
                linearLayout.setBackgroundColor(Color.GREEN);
            } else {
                linearLayout.setBackgroundColor(Color.WHITE);
            }

            TextView textView1 = convertView.findViewById(R.id.TextView01);
            TextView textView2 = convertView.findViewById(R.id.TextView02);
            textView1.setText(getChild(groupPosition, childPosition, 0));
            textView2.setText(getChild(groupPosition, childPosition, 1));

            return convertView;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            // グループのViewを作る処理
            // convertViewがnullの時だけインフレートする（１行ごとに呼ばれるので使いまわす）
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.expandablegroupview,
                        null);
            }

            // 子要素の現在位置が偶数の場合はグレー、奇数の場合は黒を背景にセットする
            LinearLayout linearLayout = (LinearLayout) convertView
                    .findViewById(R.id.GroupLinearLayout);
            if ((groupPosition % 2) == 0) {
                linearLayout.setBackgroundColor(Color.LTGRAY);
            } else {
                linearLayout.setBackgroundColor(Color.WHITE);
            }

            TextView textView = (TextView) convertView.findViewById(R.id.GroupTextView01);
            textView.setText(getGroup(groupPosition).toString());

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

    }
}