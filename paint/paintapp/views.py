from django.shortcuts import render

# Create your views here.
from django.http import HttpResponse, HttpResponseRedirect
from paintapp.models import Files
from django.views.decorators.csrf import csrf_exempt

from paintapp.Ladder import Ladder
import json

@csrf_exempt
def paint(request):
    if request.method == 'GET':
        return render(request, 'paint.html')
    elif request.method == 'POST':
        filename = request.POST['save_fname']
        data = request.POST['save_cdata']
        image = request.POST['save_image']
        file_data = Files(name=filename, image=data, canvas_image=image)
        file_data.save()
        return HttpResponseRedirect('/')

@csrf_exempt
def ready(request):
    if request.method == 'POST':
        pcnt = 0
        try:
            pcnt = int(request.POST['people_cnt'])
            w = int(request.POST['w'])
            h = int(request.POST['h'])
        except ValueError as e:
            print("value error")
        ladder = Ladder(pcnt, w, h)
        data = {}
        data['mat'] = ladder.matrix
        data['points'] = ladder.points
        data['x'] = ladder.x
        data['y'] = ladder.y
        return HttpResponse(json.dumps(data), content_type="application/json")

@csrf_exempt
def start(request):
    if request.method == 'POST':
        filename = request.POST['people_cnt']
        return None