package com.util;

import java.awt.Color;
import java.awt.GridBagConstraints;

public class SystemParameters {

    public static final String systemname = "檔案資訊系統";

    public static final String objText[] = {"路徑",
                                            "檔案資訊",
                                            "檔案內容",
                                            "開啟檔案",
                                            "讀取內容",
                                            "加密",
                                            "解密",
                                            "文字顏色",
                                            "背景顏色",
                                            "文字大小"
    };

    public static final String objfile[] = {"檔案長度",
                                            "是否為檔案",
                                            "是否為目錄",
                                            "是否可讀",
                                            "是否可寫",
                                            "是否隱藏",
                                            "最後修改日期",
                                            "檔案名稱",
                                            "檔案路徑",
                                            "絕對路徑"                   
    };

    private static int NONE = GridBagConstraints.NONE;
    private static int WEST = GridBagConstraints.WEST;
    private static int BOTH = GridBagConstraints.BOTH;
    private static int CENTER = GridBagConstraints.CENTER;

    public static final int[][] gbc = {{0,0,1,1,0,0,NONE,WEST}, //Label_filepath
                                       {0,1,1,1,0,0,NONE,WEST}, //Label_information
                                       {0,13,1,1,0,0,NONE,WEST}, //Label_filecontent
                                       {1,0,6,1,1,0,BOTH,WEST}, //Text_filepathway
                                       {1,1,4,4,1,1,BOTH,WEST}, //ScrollPane_imformation
                                       {1,13,4,4,1,1,BOTH,WEST}, //ScrollPane_filecontent
                                       {1,12,1,1,1,0,BOTH,CENTER}, //Button_openfile
                                       {2,12,1,1,1,0,BOTH,CENTER}, //Button_roadfile
                                       {3,12,1,1,1,0,BOTH,CENTER}, //Button_encode
                                       {4,12,1,1,1,0,BOTH,CENTER}, //Button_decode
                                       {1,6,1,1,1,0,BOTH,WEST}, //checkbox_filelength 
                                       {2,6,1,1,1,0,BOTH,WEST}, //checkbox_isfile
                                       {3,6,1,1,1,0,BOTH,WEST}, //checkbox_isdirectory
                                       {4,6,1,1,1,0,BOTH,WEST}, //checkbox_canread
                                       {1,7,1,1,1,0,BOTH,WEST}, //checkbox_canwrite
                                       {2,7,1,1,1,0,BOTH,WEST}, //checkbox_ishidden
                                       {3,7,1,1,1,0,BOTH,WEST}, //checkbox_lastmodify
                                       {4,7,1,1,1,0,BOTH,WEST}, //checkbox_getname
                                       {1,8,1,1,1,0,BOTH,WEST}, //checkbox_getpath
                                       {2,8,1,1,1,0,BOTH,WEST}, //checkbox_getabsolutepath
                                       {3,8,1,1,1,0,BOTH,WEST}, //radiobutton_1
                                       {4,8,1,1,1,0,BOTH,WEST}, //radiobitton_2
                                       {5,8,1,1,1,0,BOTH,WEST}, //radiobutton_usersetting
                                       {1,9,1,1,1,0,BOTH,WEST}, //Label_forecolor
                                       {3,9,1,1,1,0,BOTH,CENTER}, //Label_backcolor
                                       {1,10,1,1,1,0,BOTH,CENTER}, //Label_textsize
                                       {2,9,1,1,1,0,BOTH,CENTER}, //combobox_fore
                                       {4,9,1,1,1,0,BOTH,CENTER}, //combo_back
                                       {2,10,1,1,1,0,BOTH,CENTER}, //silder
                                       {5,10,1,1,1,0,BOTH,WEST} //silder_text
	};

    public static final Color[][] textstyle = {{Color.BLACK,Color.WHITE},
                                               {Color.YELLOW,Color.BLACK}
    };

    public static final String[] objcolor = {"黑色",
                                             "黃色",
                                             "灰色",
                                             "綠色",
                                             "紅色",
                                             "藍色"
    };

}
