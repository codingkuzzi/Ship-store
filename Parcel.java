class Parcel {
  public int mLength;
  public int mWidth;
  public int mHeight;
  public int mVolume;
  public int mWeight;
  public int mDistance;
  public int mCost;
  public int mSurfaceArea;
  public boolean mGiftWrap;
  public String mSpeed;

  public Parcel(int length, int width, int height, int weight, int distance, boolean giftWrap, String speed){
    mLength = length;
    mWidth = width;
    mHeight = height;
    mWeight = weight;
    mDistance = distance;
    mGiftWrap = giftWrap;
    mSpeed = speed;
  }

  public int calculateVolume() {
    mVolume = mLength * mWidth * mHeight;
    return mVolume;
  }

  public int calculateSurfaceArea() {
    mSurfaceArea = ((mLength * mHeight) * 4) + ((mLength * mWidth) * 2);
    return mSurfaceArea;
  }

  public int calculateCost() {
    //baseline shipping cost
    mCost = mVolume*3 + mWeight*2 + mDistance*2;
    //add gift wrap
    if (mGiftWrap == true) {
      mCost *= 2;
    }
    //factor in shipping method
    if (mSpeed.equals("overnight")) {
      mCost = mCost + mDistance*3;
    } else if (mSpeed.equals("2-day")) {
      mCost = mCost + mDistance*2;
    } else {
      mCost = mCost + mDistance;
    }
    
  }

}
