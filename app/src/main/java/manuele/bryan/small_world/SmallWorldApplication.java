package manuele.bryan.small_world;

import android.app.Application;

import com.parse.Parse;

public class SmallWorldApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "j1sOBRjhmfTDFFfcsIc90bZvNlV1E0YItHB9iRKX",
                "ZVMo35d4PmJtDpp1zWpuTSXeAxxgcbFfh4Plvuty");
    }

}