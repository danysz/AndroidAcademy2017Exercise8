package tlv.academy.android.fundamentals_exercise_8;

import java.io.Serializable;

/**
 * Created by danielszasz on 22/12/2017.
 */

public class TransferDetails implements Serializable {
    private static final long serialVersionUID = 5351872234181943492L;

    private String mFileName;
    private int mProgress;
    private long mCurrentFileSize;
    private long mTotalFileSize;

    public TransferDetails() {
    }


    public TransferDetails(String aFileName, int aProgress, long aCurrentFileSize, long aTotalFileSize) {
        mFileName = aFileName;
        mProgress = aProgress;
        mCurrentFileSize = aCurrentFileSize;
        mTotalFileSize = aTotalFileSize;
    }

    public String getFileName() {
        return mFileName;
    }

    public void setFileName(String aFileName) {
        mFileName = aFileName;
    }

    public int getProgress() {
        return mProgress;
    }

    public void setProgress(int aProgress) {
        mProgress = aProgress;
    }

    public long getCurrentFileSize() {
        return mCurrentFileSize;
    }

    public void setCurrentFileSize(long aCurrentFileSize) {
        mCurrentFileSize = aCurrentFileSize;
    }

    public long getTotalFileSize() {
        return mTotalFileSize;
    }

    public void setTotalFileSize(long aTotalFileSize) {
        mTotalFileSize = aTotalFileSize;
    }
}
