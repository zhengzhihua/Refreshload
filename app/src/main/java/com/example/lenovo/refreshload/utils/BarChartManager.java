package com.example.lenovo.refreshload.utils;

import android.graphics.Color;
import android.graphics.Typeface;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhihua on 2018/11/12.10:22
 * Update 2018/11/12 10:22
 * Describe
 */

public class BarChartManager {
    private BarChart mBarChart;
    private YAxis leftAxis;
    private YAxis rightAxis;
    private XAxis xAxis;
    private DecimalFormat mFormat;
    public BarChartManager(BarChart barChart) {
        this.mBarChart = barChart;
        leftAxis = mBarChart.getAxisLeft();
        rightAxis = mBarChart.getAxisRight();
        xAxis = mBarChart.getXAxis(); }

    /**
     * 初始化LineChart
     */
    private void initLineChart() {
        mFormat = new DecimalFormat("#,###.##");
        //背景颜色
        mBarChart.setBackgroundColor(Color.WHITE);
        //是否显示网格背景
        mBarChart.setDrawGridBackground(false);
        //显示每条背景阴影
        mBarChart.setDrawBarShadow(false);
        //设置图标边框的颜色
        mBarChart.setBorderColor(Color.parseColor("#ff0000"));

        mBarChart.setTouchEnabled(true); // 所有触摸事件,默认true
        mBarChart.setDragEnabled(true);    // 可拖动,默认true
        mBarChart.setScaleEnabled(false);   // 两个轴上的缩放,X,Y分别默认为true
        mBarChart.setScaleXEnabled(false);  // X轴上的缩放,默认true
        mBarChart.setScaleYEnabled(false);  // Y轴上的缩放,默认true
        mBarChart.setPinchZoom(false);  // X,Y轴同时缩放，false则X,Y轴单独缩放,默认false
        mBarChart.setDoubleTapToZoomEnabled(false); // 双击缩放,默认true
        mBarChart.setDragDecelerationEnabled(true);    // 抬起手指，继续滑动,默认true
        //显示边界
        mBarChart.setDrawBorders(false);
        //设置XY动画效果
        mBarChart.animateY(1000, Easing.EasingOption.Linear);
        mBarChart.animateX(1000, Easing.EasingOption.Linear);
//      不显示描述信息
        mBarChart.getDescription().setEnabled(false);
//         图例设置
        Legend legend = mBarChart.getLegend();
        //不显示图例
        legend.setForm(Legend.LegendForm.NONE);
//        图例文字的大小
        legend.setTextSize(11f);
        //显示位置
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        //XY轴的设置
        //X轴设置显示位置在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//      X轴最小间距
        xAxis.setGranularity(1f);
        //      不绘制网格线
        xAxis.setDrawGridLines(false);
//      X轴字体样式
        xAxis.setTypeface(Typeface.DEFAULT_BOLD);
        //      设置X轴文字剧中对齐
        xAxis.setCenterAxisLabels(true);
//
//       保证Y轴从0开始，不然会上移一点
        leftAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f);
        leftAxis.setAxisMinimum(0f);
        leftAxis.setTextColor(Color.parseColor("#2C2C2C"));
//        // 线跟数据都不显示
        rightAxis.setEnabled(false); //右侧Y轴不显示
    }

    /**
     * 展示柱状图(一条)
     */
    public void showBarChart(List<BarEntry> yVals, String label, int color, int Ymax, String[] xvalues) {
        initLineChart();
        // 每一个BarDataSet代表一类柱状图
        BarDataSet barDataSet = new BarDataSet(yVals, label);
        barDataSet.setColor(color);
        //是否显示顶部的值
        barDataSet.setDrawValues(true);
//        文字的大小
        barDataSet.setValueTextSize(9f);
        barDataSet.setFormLineWidth(1f);
        barDataSet.setFormSize(15.0f);
        ArrayList<IBarDataSet> dataSets = new ArrayList<>();
        dataSets.add(barDataSet);
        BarData data = new BarData(dataSets);
        //设置宽度
        data.setBarWidth(0.3f);
        //设置X轴的刻度数
        String[] xValues = xvalues;
        String[] yValues = {"91%", "92%", "93%", "94%", "95%", "96%"};
        xAxis.setLabelCount(yVals.size() + 1, true);
        xAxis.setDrawLabels(true);
        IAxisValueFormatter xAxisFormatter = new XAxisValueFormatter(xValues);
        xAxis.setValueFormatter(xAxisFormatter);
        xAxis.setTextColor(Color.parseColor("#2C2C2C"));
        xAxis.setAxisLineColor(Color.parseColor("#d5d5d5"));
        IAxisValueFormatter custom = new MyYAxisValueFormatter(yValues);
        leftAxis.setValueFormatter(custom);
        leftAxis.setAxisLineColor(Color.parseColor("#d5d5d5"));
//        设置Y轴的最小值和最大值
        leftAxis.setAxisMaximum((float)(Ymax+50));
        leftAxis.setAxisMinimum(0f);
        mBarChart.setData(data);
    }
    public class MyYAxisValueFormatter implements IAxisValueFormatter {

        private String[] xValues;
        public MyYAxisValueFormatter(String[] yValues) {
            xValues = yValues;
        }
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
//        return mFormat.format(value) + "%";
            return mFormat.format(value);
        }
    }
    class XAxisValueFormatter implements IAxisValueFormatter {

        private String[] xValues;

        public XAxisValueFormatter(String[] xValues) {
            this.xValues = xValues;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return xValues[(int) value];
        }
    }
}
