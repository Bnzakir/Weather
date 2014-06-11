//
//  Shader.fsh
//  newone
//
//  Created by Zakir Baghriov on 11/06/2014.
//  Copyright (c) 2014 ___FULLUSERNAME___. All rights reserved.
//

varying lowp vec4 colorVarying;

void main()
{
    gl_FragColor = colorVarying;
}
