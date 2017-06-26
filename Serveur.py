from flask import Flask, request
from flask_cors import CORS, cross_origin
from pprint import pprint
import random
import json

app = Flask(__name__)
app.debug = True
CORS(app)

identifiant=['adrien']
postSales=[]
nombre = ['toto','tata','titi']

weather = []

@app.route("/reset", methods=["GET"])
def getReset():
	global nombre
	temp = random.choice(nombre)
	return json.dumps(temp),200,{'Content-Type':'application/json'}

@app.route("/weather/get", methods=["GET"])
def getWeather():
	return json.dumps(weather),200,{'Content-Type':'application/json'}


@app.route("/sales",methods=["POST"])
def postSales():
 	global  postSales
 	postSales = request.get_json()
 	print (postSales)


@app.route("/idPost",methods=["POST"])
def postId():
 	global  identifiant
 	#tmp = request.get_json()
 	tmp = request.get_data()
 	tmp = json.loads(tmp)
 	identifiant.append(tmp)
 	print (identifiant)
 	return json.dumps(identifiant),200,{'Content-Type':'application/json'}

@app.route("/idIsValide",methods=["POST"])
def postIdIsValide():
 	global  identifiant
 	idvalide= request.get_data()
 	idvalide = json.loads(tmp)
 	for x in identifiant:
 		if idvalide in identifiant:
 			return json.dumps(idvalide),200,{'Content-Type':'application/json'}
 		else :continue

 	print (identifiant)

@app.route("/weather/post", methods=["POST"])
def postWheather():
 	global weather
 	tmp = request.get_data()
 	weather.append(tmp)
 	print (weather)
 	return json.dumps(weather),200,{'Content-Type':'application/json'}


#@app.route("/idGet",methods=["GET"])
#def idGet():
#	return "test"

if __name__ == "__main__":
 	app.run()
