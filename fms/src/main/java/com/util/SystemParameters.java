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
                                            "解密"
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
                                       {0,10,5,1,0,0,NONE,WEST}, //Label_filecontent
                                       {1,0,4,1,1,0,BOTH,WEST}, //Text_filepathway
                                       {1,1,4,4,1,1,BOTH,WEST}, //ScrollPane_imformation
                                       {1,10,4,7,1,1,BOTH,WEST}, //ScrollPane_filecontent
                                       {1,9,1,1,1,0,BOTH,CENTER}, //Button_openfile
                                       {2,9,1,1,1,0,BOTH,CENTER}, //Button_roadfile
                                       {3,9,1,1,1,0,BOTH,CENTER}, //Button_encode
                                       {4,9,1,1,1,0,BOTH,CENTER}, //Button_decode
                                       {1,5,1,1,1,0,BOTH,WEST}, //checkbox_filelength 
                                       {2,5,1,1,1,0,BOTH,WEST}, //checkbox_isfile
                                       {3,5,1,1,1,0,BOTH,WEST}, //checkbox_isdirectory
                                       {4,5,1,1,1,0,BOTH,WEST}, //checkbox_canread
                                       {1,6,1,1,1,0,BOTH,WEST}, //checkbox_canwrite
                                       {2,6,1,1,1,0,BOTH,WEST}, //checkbox_ishidden
                                       {3,6,1,1,1,0,BOTH,WEST}, //checkbox_lastmodify
                                       {4,6,1,1,1,0,BOTH,WEST}, //checkbox_getname
                                       {1,7,1,1,1,0,BOTH,WEST}, //checkbox_getpath
                                       {2,7,1,1,1,0,BOTH,WEST}, //checkbox_getabsolutepath
                                       {3,7,1,1,1,0,BOTH,WEST}, //radiobutton_1
                                       {4,7,1,1,1,0,BOTH,WEST}  //radiobitton_2
	};

    public static final Color[][] textstyle = {{Color.BLACK,Color.WHITE},
                                               {Color.YELLOW,Color.BLACK}
    };

}
