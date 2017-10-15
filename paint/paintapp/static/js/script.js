var canvas = document.getElementById("paint");
var ctx = canvas.getContext("2d");
ctx.lineWidth = 2;
ctx.font = "20px verdana";

var color_list = ['#ff0000',
              '#ff8c00',
              '#ffff00',
              '#008000',
              '#00D8FF',
              '#0000ff',
              '#4b0082',
              '#800080',
              '#800080'];

var INTERVAL_COUNT = 5;
var TIME_INTERVAL = 1 / INTERVAL_COUNT;

var cur_id = 0;
var cur_winner = -1;
var cur_ladder = null;
function draw_cur_ladder (){
    draw_ladder (cur_ladder, cur_winner);
    cur_id = 0;
}
function draw_ladder (ladder_info, set_winner){
    cur_ladder = ladder_info;
    cur_id = 0;
    var x = ladder_info.x;
    var y = ladder_info.y;
    var mat = ladder_info.mat;
    var pt_mat = ladder_info.points;

    for (i = 0; i < x; i++){
        ctx.fillStyle = color_list[i];
        ctx.fillText((i + 1).toString(), pt_mat[0][i][0] - 5, pt_mat[0][i][1] - 5);
        ctx.beginPath();
        ctx.moveTo(pt_mat[0][i][0], pt_mat[0][i][1]);
        ctx.lineTo(pt_mat[y - 1][i][0], pt_mat[y - 1][i][1]);
        ctx.strokeStyle = "#A9A9A9";
        ctx.stroke();

        for (j = 1; j < y-1; j++){
            if(mat[j][i] == 1 && i != x - 1 && mat[j][i + 1] == 1){
                ctx.beginPath();
                ctx.moveTo(pt_mat[j][i][0], pt_mat[j][i][1]);
                ctx.lineTo(pt_mat[j][i + 1][0], pt_mat[j][i][1]);
                ctx.strokeStyle = "#A9A9A9";
                ctx.stroke();
            }
        }
    }

    var winner = 0;
    if (set_winner == -1) {
        winner = Math.floor((Math.random() * x));
    } else {
        winner = set_winner;
    }
    cur_winner = winner;
    ctx.fillStyle = "#000000";
    ctx.fillText("당첨!!", pt_mat[0][winner][0] - 20, pt_mat[y - 1][winner][1] + 20);
}

function next() {
    draw_path(cur_id, color_list[cur_id]);
    if (cur_id >= cur_ladder.x) {
        cur_id = 0;
    } else {
        cur_id ++;
    }
}

function draw_path (i, color){
    var mat = cur_ladder.mat;
    var points = cur_ladder.points;
    var mat_x = i;
    var mat_y = 1;
    var cur_pt = points[0][i];
    var next_pt = points[1][i];
    var virtical = false;

    while (next_pt[1] < points[points.length - 1][0][1]){

        ctx.beginPath();
        ctx.moveTo(cur_pt[0], cur_pt[1]);
        ctx.lineTo(next_pt[0], next_pt[1]);
        ctx.strokeStyle = color;
        ctx.stroke();

        if (virtical==false && mat[mat_y][mat_x] == 1 && mat_x != cur_ladder.x - 1 && mat[mat_y][mat_x + 1] == 1){
            mat_x = mat_x + 1;
            virtical = true;
        }
        else if (virtical==false && mat[mat_y][mat_x] == 1 && mat_x != cur_ladder.x + 1 && mat[mat_y][mat_x - 1] == 1){
            mat_x = mat_x - 1;
            virtical = true;
        }
        else {
            mat_y = mat_y + 1;
            virtical = false;
        }
        cur_pt = next_pt;
        next_pt = points[mat_y][mat_x];
    }
    ctx.beginPath();
    ctx.moveTo(cur_pt[0], cur_pt[1]);
    ctx.lineTo(next_pt[0], next_pt[1]);
    ctx.strokeStyle = color;
    ctx.stroke();
}
