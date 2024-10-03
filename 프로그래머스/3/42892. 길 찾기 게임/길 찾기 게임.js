class Node{
    constructor(idx, x, y){
        this.idx = idx
        this.x = x
        this.y = y
        this.left = 0
        this.right = 0
    }
}

function divideTree(nodes, x){    
    const left = []
    const right = []
    nodes.forEach(node => {
        if(node[0] < x){
            left.push(node)
        }
        else if(node[0] > x){
            right.push(node)
        }
    })
    
    return [left, right]    
}

function makeTree(nodes, parent){
    if(nodes.length == 0) return
    
    const rootx = parent.x
    const [x, y, idx] = nodes[0]
    const newNode = new Node(idx, x, y)
    
    if(x < rootx){
        parent.left = newNode
    }else if(rootx < x){
        parent.right = newNode
    }
    
    
    const [left, right] = divideTree(nodes, x)
    // console.log('left::', left)
    // console.log('right::', right)
    // 왼쪽
    makeTree(left, newNode)
    // 오른쪽
    makeTree(right, newNode)
}

function preRead(node, arr){
    if(!node.idx) return
    
    arr.push(node.idx)
    preRead(node.left, arr)
    preRead(node.right, arr)
    
    return arr
}

function postRead(node, arr){
    if(!node.idx) return
    
    postRead(node.left, arr)
    postRead(node.right, arr)
    arr.push(node.idx)
    
}

function solution(nodeinfo) {
    var answer = [[]];
    
    const n = nodeinfo.length
    
    // 번호 추가
    nodeinfo.forEach((info, i) => {
        info.push(i + 1)
    })
    
    // 정렬
    nodeinfo.sort((a,b) => {
        if(a[1] == b[1]){
            return a[0] - b[0]
        }else{
            return b[1] - a[1]
        }
    })
    
    // x기준으로 왼쪽 오른쪽 반 쪼개서 트리생성
    const [x, y, idx] = nodeinfo[0]
    const root = new Node(idx, x, y)
    const [left, right] = divideTree(nodeinfo, x)
    // 왼쪽
    makeTree(left, root)
    // 오른쪽
    makeTree(right, root)
    
    //
    const preList = []
    preRead(root, preList)
    
    const postList = []
    postRead(root, postList)
    
    return [preList, postList];
}
