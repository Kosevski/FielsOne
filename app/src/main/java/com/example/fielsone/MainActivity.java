package com.example.fielsone;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button reset;
    ImageView[] fields;
    private boolean player1turn = true;
    int roundCount;
    int player1fieldsCount, player2fieldsCount;
    TextView player1CountTv, player2CountTv;

//    int white = getColor(R.color.white);
//    int red = getColor(R.color.red);
//    int red_light = getColor(R.color.red_light);
//    int blue = getColor(R.color.blue);
//    int blue_light = getColor(R.color.blue_light);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1CountTv = findViewById(R.id.RedFieldsCountTv);
        player2CountTv = findViewById(R.id.BlueFieldsCountTv);


        fields = new ImageView[]{
                findViewById(R.id.field_1), findViewById(R.id.field_2), findViewById(R.id.field_3),
                findViewById(R.id.field_4), findViewById(R.id.field_5), findViewById(R.id.field_6),
                findViewById(R.id.field_7), findViewById(R.id.field_8), findViewById(R.id.field_9),
                findViewById(R.id.field_10), findViewById(R.id.field_11), findViewById(R.id.field_12),
                findViewById(R.id.field_13), findViewById(R.id.field_14), findViewById(R.id.field_15),
                findViewById(R.id.field_16), findViewById(R.id.field_17), findViewById(R.id.field_18),
                findViewById(R.id.field_19), findViewById(R.id.field_20), findViewById(R.id.field_21),
                findViewById(R.id.field_22), findViewById(R.id.field_23), findViewById(R.id.field_24),
                findViewById(R.id.field_25)
        };

        reset = findViewById(R.id.btn_reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 25; i++) {
                    fields[i].setBackgroundColor(getColor(R.color.white));

                    player1fieldsCount = 0;
                    player2fieldsCount = 0;
                    String player2fieldsCountString = Integer.toString(0);
                    player1CountTv.setText(player2fieldsCountString);

                    String player1fieldsCountString = Integer.toString(0);
                    player2CountTv.setText(player1fieldsCountString);
                }
            }
        });
    }

    ColorDrawable drawable, drawable1, drawable2, drawable3, drawable4;

    public void fieldClick(View view) {
        int[] fieldsToTake = takeFields(getPosition(view));
        if (player1turn) {
             drawable = (ColorDrawable) view.getBackground();
             drawable1 = (ColorDrawable) fields[fieldsToTake[1]].getBackground();
             if (fieldsToTake.length > 2) {
                drawable2 = (ColorDrawable) fields[fieldsToTake[2]].getBackground();
                if (fieldsToTake.length > 3) {
                    drawable3 = (ColorDrawable) fields[fieldsToTake[3]].getBackground();
                    if (fieldsToTake.length > 4) {
                        drawable4 = (ColorDrawable) fields[fieldsToTake[4]].getBackground();
                    }
                }
            }
            if (drawable.getColor() == getColor(R.color.white)) {
                fields[fieldsToTake[0]].setBackgroundColor(getColor(R.color.red));
                player1fieldsCount++;
                String player1fieldsCountString = Integer.toString(player1fieldsCount);
                player1CountTv.setText(player1fieldsCountString);
                if (drawable1.getColor() == getColor(R.color.white)) {
                    fields[fieldsToTake[1]].setBackgroundColor(getColor(R.color.red_light));
                } else if (drawable1.getColor() == getColor(R.color.blue_light)) {
                    fields[fieldsToTake[1]].setBackgroundColor(getColor(R.color.white));
                }

                if (fieldsToTake.length > 2) {
                    if (drawable2.getColor() == getColor(R.color.white)) {
                        fields[fieldsToTake[2]].setBackgroundColor(getColor(R.color.red_light));
                    } else if (drawable2.getColor() == getColor(R.color.blue_light)) {
                        fields[fieldsToTake[2]].setBackgroundColor(getColor(R.color.white));
                    }

                    if (fieldsToTake.length > 3) {
                        if (drawable3.getColor() == getColor(R.color.white)) {
                            fields[fieldsToTake[3]].setBackgroundColor(getColor(R.color.red_light));
                        } else if (drawable3.getColor() == getColor(R.color.blue_light)) {
                            fields[fieldsToTake[3]].setBackgroundColor(getColor(R.color.white));
                        }

                        if (fieldsToTake.length > 4) {
                            if (drawable4.getColor() == getColor(R.color.white)) {
                                fields[fieldsToTake[4]].setBackgroundColor(getColor(R.color.red_light));
                            } else if (drawable4.getColor() == getColor(R.color.blue_light)) {
                                fields[fieldsToTake[4]].setBackgroundColor(getColor(R.color.white));
                            }

                        }
                    }
                }
            }
        } else {
            drawable = (ColorDrawable) view.getBackground();
            drawable1 = (ColorDrawable) fields[fieldsToTake[1]].getBackground();
            if (fieldsToTake.length > 2) {
                drawable2 = (ColorDrawable) fields[fieldsToTake[2]].getBackground();
                if (fieldsToTake.length > 3) {
                    drawable3 = (ColorDrawable) fields[fieldsToTake[3]].getBackground();
                    if (fieldsToTake.length > 4) {
                        drawable4 = (ColorDrawable) fields[fieldsToTake[4]].getBackground();
                    }
                }
            }
            if (drawable.getColor() == getColor(R.color.white)) {
                fields[fieldsToTake[0]].setBackgroundColor(getColor(R.color.blue));
                player2fieldsCount++;
                String player2fieldsCountString = Integer.toString(player2fieldsCount);
                player2CountTv.setText(player2fieldsCountString);
                if (drawable1.getColor() == getColor(R.color.white)) {
                    fields[fieldsToTake[1]].setBackgroundColor(getColor(R.color.blue_light));
                } else if (drawable1.getColor() == getColor(R.color.red_light)) {
                    fields[fieldsToTake[1]].setBackgroundColor(getColor(R.color.white));
                }

                if (fieldsToTake.length > 2) {
                    if (drawable2.getColor() == getColor(R.color.white)) {
                        fields[fieldsToTake[2]].setBackgroundColor(getColor(R.color.blue_light));
                    } else if (drawable2.getColor() == getColor(R.color.red_light)) {
                        fields[fieldsToTake[2]].setBackgroundColor(getColor(R.color.white));
                    }

                    if (fieldsToTake.length > 3) {
                        if (drawable3.getColor() == getColor(R.color.white)) {
                            fields[fieldsToTake[3]].setBackgroundColor(getColor(R.color.blue_light));
                        } else if (drawable3.getColor() == getColor(R.color.red_light)) {
                            fields[fieldsToTake[3]].setBackgroundColor(getColor(R.color.white));
                        }

                        if (fieldsToTake.length > 4) {
                            if (drawable4.getColor() == getColor(R.color.white)) {
                                fields[fieldsToTake[4]].setBackgroundColor(getColor(R.color.blue_light));
                            } else if (drawable4.getColor() == getColor(R.color.red_light)) {
                                fields[fieldsToTake[4]].setBackgroundColor(getColor(R.color.white));
                            }
                        }
                    }
                }
            }
        }
        roundCount++;
        if (roundCount != 100000) {
            player1turn = !player1turn;
        }
    }

    public int getPosition(View view) {
        for (int i = 0; i < 25; i++) {
            if (view.getId() == fields[i].getId()) {
                return i;
            }
        }
        return 0;
    }


    public int[] takeFields(int i) {
        int[] positionsForField1;
        if (i == 0) {
            positionsForField1 = new int[]{i, i + 1, i + 5};
        } else if (i == 24) {
            positionsForField1 = new int[]{i, i - 1, i - 5};
        } else if (i == 4) {
            positionsForField1 = new int[]{i, i - 1, i + 5};
        } else if (i == 20) {
            positionsForField1 = new int[]{i, i + 1, i - 5};
        } else if (i >= 1 && i <= 3) {
            positionsForField1 = new int[]{i, i + 1, i - 1, i + 5};
        } else if (i >= 21 && i <= 23) {
            positionsForField1 = new int[]{i, i + 1, i - 1, i - 5};
        } else if (i >= 6 && i <= 8) {
            positionsForField1 = new int[]{i, i + 1, i - 1, i - 5, i + 5};
        } else if (i >= 11 && i <= 13) {
            positionsForField1 = new int[]{i, i + 1, i - 1, i - 5, i + 5};
        } else if (i >= 16 && i <= 18) {
            positionsForField1 = new int[]{i, i + 1, i - 1, i - 5, i + 5};
        } else if (i == 5 || i == 10 || i == 15) {
            positionsForField1 = new int[]{i, i + 1, i - 5, i + 5};
        } else {
            positionsForField1 = new int[]{i, i - 1, i - 5, i + 5};
        }
        return positionsForField1;
    }

}