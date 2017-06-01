package com.stroopgame.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.stroopgame.R;
import com.stroopgame.dao.ChartData;
import com.stroopgame.dao.Dao;
import com.stroopgame.dao.DataDto;
import com.stroopgame.dao.DataPoint;
import com.stroopgame.dao.FileBasedDao;
import com.stroopgame.io.FileIO;
import com.stroopgame.util.DateUtil;
import com.stroopgame.util.FileUtil;
import com.stroopgame.util.StartScreenActivityIntentUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import static com.stroopgame.dao.DataDtoConversion.convertToChartData;
import static com.stroopgame.util.ChartUtil.dataSetForYAxis;
import static com.stroopgame.util.ChartUtil.setUpChart;

public class ChartActivity extends AppCompatActivity {

    private Dao dao;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );

        File file = FileUtil.getDataFile( this );

        dao = new FileBasedDao( new FileIO( file ) );

        setContentView( R.layout.chart_screen );

        LineChart lineChart = ( LineChart ) findViewById( R.id.line_chart );

        DataPoint lastDataPoint = extractDatePointFromExtras();

        final DataDto allDataSoFar = dao.read().sortedDataPoints().addDataPoint( lastDataPoint );
        setData( lineChart, allDataSoFar );

        Button continueButton = ( Button ) findViewById( R.id.char_continue );

        continueButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                dao.write( allDataSoFar.shrinkDataSize() );
                StartScreenActivityIntentUtil.backToStartScreen( v, ChartActivity.this );
            }
        } );
    }

    private void setData( LineChart mChart, DataDto dto ) {

        ChartData chartData = convertToChartData( dto );

        LineDataSet dataSet = dataSetForYAxis( chartData.getyVals() );

        ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
        dataSets.add( dataSet );

        setUpChart( mChart, new LineData( chartData.getxVals(), dataSets ) );
    }

    private DataPoint extractDatePointFromExtras( ) {
        Bundle extras = getIntent().getExtras();

        int score = 0;
        Date date = new Date();

        if ( extras != null ) {
            score = Integer.valueOf( extras.getString( GameScreenActivity.FINAL_SCORE ) );
            date = DateUtil.parse( extras.getString( ContinueScreenActivity.DATE ) );
        }
        return new DataPoint( date, score );
    }


}
